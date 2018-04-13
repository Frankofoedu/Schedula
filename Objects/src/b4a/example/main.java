package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (add.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, messaging.class));
 {
            Activity __a = null;
            if (add.previousOne != null) {
				__a = add.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(add.mostCurrent == null ? null : add.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsplash = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlhome = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrlvsent = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrlvqueue = null;
public anywheresoftware.b4a.objects.TabStripViewPager _tabstrip1 = null;
public static int _paneltop = 0;
public static String _panelheight = "";
public static int _count = 0;
public b4a.example.starter _starter = null;
public b4a.example.messaging _messaging = null;
public b4a.example.add _add = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="timer1.Initialize(\"Timer1\",3000)";
_timer1.Initialize(processBA,"Timer1",(long) (3000));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="TabStrip1.LoadLayout(\"queue\",\"QUEUE\")";
mostCurrent._tabstrip1.LoadLayout("queue",BA.ObjectToCharSequence("QUEUE"));
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="TabStrip1.LoadLayout(\"sent\",\"SENT\")";
mostCurrent._tabstrip1.LoadLayout("sent",BA.ObjectToCharSequence("SENT"));
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="ScrlvQueue.Panel.Width = ScrlvQueue.Width";
mostCurrent._scrlvqueue.getPanel().setWidth(mostCurrent._scrlvqueue.getWidth());
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="ScrlvSent.Panel.Width = ScrlvSent.Width";
mostCurrent._scrlvsent.getPanel().setWidth(mostCurrent._scrlvsent.getWidth());
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="ScrlvQueue.Panel.Height = ( Activity.Height - 60)";
mostCurrent._scrlvqueue.getPanel().setHeight((int) ((mostCurrent._activity.getHeight()-60)*0.1));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="ScrlvQueue.Color = Colors.green";
mostCurrent._scrlvqueue.setColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="File.Delete(File.DirInternal, \"Schedule.db\") ' o";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Schedule.db");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="If File.Exists(File.DirInternal, \"Schedule.db\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Schedule.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="Messaging.SQL1.Initialize(File.DirInternal, \"Sc";
mostCurrent._messaging._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Schedule.db",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="CreateDataBase";
_createdatabase();
 };
 };
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="For Each lbl As Label In GetAllTabLabels(TabStrip";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
{
final anywheresoftware.b4a.BA.IterableList group17 = _getalltablabels(mostCurrent._tabstrip1);
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_lbl.setObject((android.widget.TextView)(group17.Get(index17)));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="lbl.Width = (PnlHome.Width)/2";
_lbl.setWidth((int) ((mostCurrent._pnlhome.getWidth())/(double)2));
 }
};
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="End Sub";
return "";
}
public static String  _createdatabase() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createdatabase"))
	return (String) Debug.delegate(mostCurrent.activityBA, "createdatabase", null);
String _query = "";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub CreateDataBase";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Private Query As String";
_query = "";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Query = \"CREATE TABLE queue (ID INTEGER PRIMARY K";
_query = "CREATE TABLE queue (ID INTEGER PRIMARY KEY, Contact TEXT, Message TEXT, DateTime INTEGER, Status INTEGER)";
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Messaging.SQL1.ExecNonQuery(Query)";
mostCurrent._messaging._sql1.ExecNonQuery(_query);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getalltablabels(anywheresoftware.b4a.objects.TabStripViewPager _tabstrip) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getalltablabels"))
	return (anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "getalltablabels", new Object[] {_tabstrip});
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tc = null;
anywheresoftware.b4a.objects.collections.List _res = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Public Sub GetAllTabLabels (tabstrip As TabStrip)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim jo As JavaObject = tabstrip";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_tabstrip));
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="r.Target = jo.GetField(\"tabStrip\")";
_r.Target = _jo.GetField("tabStrip");
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Dim tc As Panel = r.GetField(\"tabsContainer\")";
_tc = new anywheresoftware.b4a.objects.PanelWrapper();
_tc.setObject((android.view.ViewGroup)(_r.GetField("tabsContainer")));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="For Each v As View In tc";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group7 = _tc;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_v.setObject((android.view.View)(group7.Get(index7)));
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="If v Is Label Then res.Add(v)";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
_res.Add((Object)(_v.getObject()));};
 }
};
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="End Sub";
return null;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _addmsgpanel(anywheresoftware.b4a.objects.ScrollViewWrapper _scv,String _test,String _xtext,String _ytext,String _ztext) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addmsgpanel"))
	return (String) Debug.delegate(mostCurrent.activityBA, "addmsgpanel", new Object[] {_scv,_test,_xtext,_ytext,_ztext});
anywheresoftware.b4a.objects.PanelWrapper _panel0 = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgv = null;
anywheresoftware.b4a.objects.LabelWrapper _iconlbl = null;
int _j = 0;
int _k = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub AddMsgPanel(scv As ScrollView, test As String,";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim panel0 As Panel";
_panel0 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="panel0 = scv.Panel";
_panel0 = _scv.getPanel();
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Dim label1 As Label";
_label1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="Dim label2 As Label";
_label2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="Dim label3 As Label";
_label3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Dim label4 As Label";
_label4 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="Dim imgv As ImageView";
_imgv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="Dim iconlbl As Label";
_iconlbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="panel1.Initialize(\"Panel1\")";
_panel1.Initialize(mostCurrent.activityBA,"Panel1");
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="label1.Initialize(\"\")";
_label1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="label2.Initialize(\"\")";
_label2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="label3.Initialize(\"\")";
_label3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="label4.Initialize(\"\")";
_label4.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="imgv.Initialize(\"\")";
_imgv.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="iconlbl.Initialize(\"\")";
_iconlbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="Dim j As Int = panel0.Width * 0.9";
_j = (int) (_panel0.getWidth()*0.9);
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="Dim k As Int  = ( Activity.Height - 60) * 0.1";
_k = (int) ((mostCurrent._activity.getHeight()-60)*0.1);
RDebugUtils.currentLine=983067;
 //BA.debugLineNum = 983067;BA.debugLine="label1.Text  = test";
_label1.setText(BA.ObjectToCharSequence(_test));
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="label1.Text.ToUpperCase";
_label1.getText().toUpperCase();
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="label1.TextSize = 22";
_label1.setTextSize((float) (22));
RDebugUtils.currentLine=983070;
 //BA.debugLineNum = 983070;BA.debugLine="label1.TextColor = Colors.Black";
_label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983071;
 //BA.debugLineNum = 983071;BA.debugLine="label1.Typeface = Typeface.LoadFromAssets(\"kr1.tt";
_label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("kr1.ttf"));
RDebugUtils.currentLine=983072;
 //BA.debugLineNum = 983072;BA.debugLine="label1.Typeface = Typeface.DEFAULT_BOLD";
_label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=983075;
 //BA.debugLineNum = 983075;BA.debugLine="label1.Tag = 0";
_label1.setTag((Object)(0));
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="label2.TextSize = 13";
_label2.setTextSize((float) (13));
RDebugUtils.currentLine=983078;
 //BA.debugLineNum = 983078;BA.debugLine="label2.TextColor = Colors.Black";
_label2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983079;
 //BA.debugLineNum = 983079;BA.debugLine="label2.Tag = 1";
_label2.setTag((Object)(1));
RDebugUtils.currentLine=983080;
 //BA.debugLineNum = 983080;BA.debugLine="label2.Text = xtext";
_label2.setText(BA.ObjectToCharSequence(_xtext));
RDebugUtils.currentLine=983084;
 //BA.debugLineNum = 983084;BA.debugLine="label3.TextColor = Colors.Black";
_label3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983085;
 //BA.debugLineNum = 983085;BA.debugLine="label3.Typeface = Typeface.LoadFromAssets(\"violat";
_label3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("violatio.ttf"));
RDebugUtils.currentLine=983086;
 //BA.debugLineNum = 983086;BA.debugLine="label3.Gravity = Gravity.LEFT";
_label3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.LEFT);
RDebugUtils.currentLine=983087;
 //BA.debugLineNum = 983087;BA.debugLine="label3.Gravity = Gravity.BOTTOM";
_label3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.BOTTOM);
RDebugUtils.currentLine=983088;
 //BA.debugLineNum = 983088;BA.debugLine="label3.TextSize = 14";
_label3.setTextSize((float) (14));
RDebugUtils.currentLine=983089;
 //BA.debugLineNum = 983089;BA.debugLine="label3.Tag = 2";
_label3.setTag((Object)(2));
RDebugUtils.currentLine=983090;
 //BA.debugLineNum = 983090;BA.debugLine="label3.Text = ytext";
_label3.setText(BA.ObjectToCharSequence(_ytext));
RDebugUtils.currentLine=983093;
 //BA.debugLineNum = 983093;BA.debugLine="label4.TextColor = Colors.Black";
_label4.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983094;
 //BA.debugLineNum = 983094;BA.debugLine="label4.Gravity = Gravity.LEFT";
_label4.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.LEFT);
RDebugUtils.currentLine=983095;
 //BA.debugLineNum = 983095;BA.debugLine="label4.Gravity = Gravity.CENTER_VERTICAL";
_label4.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=983096;
 //BA.debugLineNum = 983096;BA.debugLine="label4.TextSize = 11";
_label4.setTextSize((float) (11));
RDebugUtils.currentLine=983097;
 //BA.debugLineNum = 983097;BA.debugLine="label4.Tag = 3";
_label4.setTag((Object)(3));
RDebugUtils.currentLine=983098;
 //BA.debugLineNum = 983098;BA.debugLine="label4.Text = ztext";
_label4.setText(BA.ObjectToCharSequence(_ztext));
RDebugUtils.currentLine=983102;
 //BA.debugLineNum = 983102;BA.debugLine="imgv.Bitmap = LoadBitmap(File.DirAssets,\"contacts";
_imgv.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"contacts-50.png").getObject()));
RDebugUtils.currentLine=983103;
 //BA.debugLineNum = 983103;BA.debugLine="imgv.Gravity = Gravity.FILL";
_imgv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=983105;
 //BA.debugLineNum = 983105;BA.debugLine="iconlbl.Text = Chr(0xE7FD)";
_iconlbl.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Chr((int) (0xe7fd))));
RDebugUtils.currentLine=983106;
 //BA.debugLineNum = 983106;BA.debugLine="iconlbl.TextColor = Colors.Black";
_iconlbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=983107;
 //BA.debugLineNum = 983107;BA.debugLine="iconlbl.TextSize = 20";
_iconlbl.setTextSize((float) (20));
RDebugUtils.currentLine=983113;
 //BA.debugLineNum = 983113;BA.debugLine="panel1.AddView(label1, j * 0.2, 0, j * 0.63, k *";
_panel1.AddView((android.view.View)(_label1.getObject()),(int) (_j*0.2),(int) (0),(int) (_j*0.63),(int) (_k*0.375));
RDebugUtils.currentLine=983114;
 //BA.debugLineNum = 983114;BA.debugLine="panel1.AddView(label2,	j * 0.2,k * 0.375, j * 0.6";
_panel1.AddView((android.view.View)(_label2.getObject()),(int) (_j*0.2),(int) (_k*0.375),(int) (_j*0.63),(int) (_k*0.625));
RDebugUtils.currentLine=983115;
 //BA.debugLineNum = 983115;BA.debugLine="panel1.AddView(label3, j * 0.83, k * 0.05, j * 0.";
_panel1.AddView((android.view.View)(_label3.getObject()),(int) (_j*0.83),(int) (_k*0.05),(int) (_j*0.17),(int) (_k*0.375));
RDebugUtils.currentLine=983116;
 //BA.debugLineNum = 983116;BA.debugLine="panel1.AddView(label4, j * 0.83, k * 0.43, j * 0.";
_panel1.AddView((android.view.View)(_label4.getObject()),(int) (_j*0.83),(int) (_k*0.43),(int) (_j*0.17),(int) (_k*0.375));
RDebugUtils.currentLine=983118;
 //BA.debugLineNum = 983118;BA.debugLine="panel1.AddView(iconlbl, 0, 0, 0.2 * j, k)";
_panel1.AddView((android.view.View)(_iconlbl.getObject()),(int) (0),(int) (0),(int) (0.2*_j),_k);
RDebugUtils.currentLine=983120;
 //BA.debugLineNum = 983120;BA.debugLine="panel0.AddView(panel1,(panel0.Width - j)/2,panelt";
_panel0.AddView((android.view.View)(_panel1.getObject()),(int) ((_panel0.getWidth()-_j)/(double)2),_paneltop,_j,_k);
RDebugUtils.currentLine=983122;
 //BA.debugLineNum = 983122;BA.debugLine="panel1.BringToFront";
_panel1.BringToFront();
RDebugUtils.currentLine=983125;
 //BA.debugLineNum = 983125;BA.debugLine="paneltop = paneltop + k + 5dip";
_paneltop = (int) (_paneltop+_k+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)));
RDebugUtils.currentLine=983127;
 //BA.debugLineNum = 983127;BA.debugLine="panel0.Height = panel0.Height + (( Activity.Heigh";
_panel0.setHeight((int) (_panel0.getHeight()+((mostCurrent._activity.getHeight()-60)*0.1)));
RDebugUtils.currentLine=983129;
 //BA.debugLineNum = 983129;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "button1_click", null);
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="AddMsgPanel(ScrlvQueue,\"hello\",\"hell\",\"none\", \"12";
_addmsgpanel(mostCurrent._scrlvqueue,"hello","hell","none","12,3");
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="End Sub";
return "";
}
public static int  _getlbels() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getlbels"))
	return (Integer) Debug.delegate(mostCurrent.activityBA, "getlbels", null);
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub getlBELS As Int";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="For Each v As View In	ScrlvQueue.Panel.GetAllVie";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = mostCurrent._scrlvqueue.getPanel().GetAllViewsRecursive();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_v.setObject((android.view.View)(group1.Get(index1)));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="If v Is Label Then";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 };
 }
};
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="Return count";
if (true) return _count;
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="End Sub";
return 0;
}
public static String  _imageview1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imageview1_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "imageview1_click", null);
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub ImageView1_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="StartActivity(Add)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._add.getObject()));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _querydbque(anywheresoftware.b4a.objects.ScrollViewWrapper _scv) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "querydbque"))
	return (String) Debug.delegate(mostCurrent.activityBA, "querydbque", new Object[] {_scv});
String _query = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub QueryDbQue(scv As ScrollView)";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim query As String = \"SELECT * FROM queue WHERE";
_query = "SELECT * FROM queue WHERE Status = 0";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim curs As Cursor = Messaging.SQL1.ExecQuery(que";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_curs.setObject((android.database.Cursor)(mostCurrent._messaging._sql1.ExecQuery(_query)));
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timer1_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "timer1_tick", null);
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Timer1_Tick";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="PnlSplash.SetVisibleAnimated(4000,False)";
mostCurrent._pnlsplash.SetVisibleAnimated((int) (4000),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="End Sub";
return "";
}
}