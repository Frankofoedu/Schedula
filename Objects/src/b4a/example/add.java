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

public class add extends Activity implements B4AActivity{
	public static add mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.add");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (add).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.add");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.add", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (add) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (add) Resume **");
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
		return add.class;
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
        BA.LogInfo("** Activity (add) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (add) Resume **");
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
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static long _alarmtime = 0L;
public static long _alarmdate = 0L;
public static boolean _booldate = false;
public static boolean _booltime = false;
public anywheresoftware.b4a.objects.LabelWrapper _lbldate = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltime = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontacts = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lstcontacts = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcontact = null;
public b4a.example.contactsutils _cu = null;
public static boolean _selected = false;
public anywheresoftware.b4a.objects.collections.List _clist = null;
public anywheresoftware.b4a.objects.PanelWrapper _pansend = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext2 = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.messaging _messaging = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Activity.LoadLayout(\"2\")";
mostCurrent._activity.LoadLayout("2",mostCurrent.activityBA);
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="cu.Initialize";
mostCurrent._cu._initialize(processBA);
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="add";
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return "";
}
public static String  _addmsg(String _sms,long _daytime,String _phoneno) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addmsg"))
	return (String) Debug.delegate(mostCurrent.activityBA, "addmsg", new Object[] {_sms,_daytime,_phoneno});
String _query = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
int _status = 0;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub AddMsg(sms As String,daytime As Long , phoneno";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim query As String";
_query = "";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Dim status As Int = 1";
_status = (int) (1);
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="query = \"SELECT * FROM queue WHERE sms = ? AND ph";
_query = "SELECT * FROM queue WHERE sms = ? AND phoneno = ?";
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="curs = Messaging.SQL1.ExecQuery2(query, Array As";
_curs.setObject((android.database.Cursor)(mostCurrent._messaging._sql1.ExecQuery2(_query,new String[]{_sms,_phoneno})));
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="If Msgbox2(\"This sms to the same person already";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("This sms to the same person already exist in the queue. Do you still want to send?"),BA.ObjectToCharSequence(""),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="query = \"INSERT INTO queue VALUES (NULL, '\" & p";
_query = "INSERT INTO queue VALUES (NULL, '"+_phoneno+"', '"+_sms+"', '"+BA.NumberToString(_daytime)+"', '"+BA.NumberToString(_status)+"')";
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="Messaging.SQL1.ExecNonQuery(query)";
mostCurrent._messaging._sql1.ExecNonQuery(_query);
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="ToastMessageShow(\"SMS added to QUEUE\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SMS added to QUEUE"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="Return";
if (true) return "";
 };
 }else {
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="query = \"INSERT INTO queue VALUES (NULL, '\" & ph";
_query = "INSERT INTO queue VALUES (NULL, '"+_phoneno+"', '"+_sms+"', '"+BA.NumberToString(_daytime)+"', '"+BA.NumberToString(_status)+"')";
RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="Messaging.SQL1.ExecNonQuery(query)";
mostCurrent._messaging._sql1.ExecNonQuery(_query);
RDebugUtils.currentLine=2162707;
 //BA.debugLineNum = 2162707;BA.debugLine="ToastMessageShow(\"SMS added to QUEUE\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SMS added to QUEUE"),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2162710;
 //BA.debugLineNum = 2162710;BA.debugLine="curs.Close";
_curs.Close();
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="End Sub";
return "";
}
public static String  _imageview4_click() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imageview4_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "imageview4_click", null);
long _smsdatetime = 0L;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub ImageView4_Click";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="If TxtContacts.Text.Trim.Length = 0 Then";
if (mostCurrent._txtcontacts.getText().trim().length()==0) { 
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="ToastMessageShow(\"please enter contact number\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("please enter contact number"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="If boolDate = False Or boolTime = False Then";
if (_booldate==anywheresoftware.b4a.keywords.Common.False || _booltime==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="ToastMessageShow(\"Enter date and time\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Enter date and time"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="If EditText2.Text.Trim.Length = 1 Then";
if (mostCurrent._edittext2.getText().trim().length()==1) { 
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="ToastMessageShow(\"Your sms is empty\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Your sms is empty"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="Dim smsDatetime As Long = alarmdate + alarmtime";
_smsdatetime = (long) (_alarmdate+_alarmtime);
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="If smsDatetime < DateTime.Now Then";
if (_smsdatetime<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="ToastMessageShow(\"This time is past\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("This time is past"),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=2097174;
 //BA.debugLineNum = 2097174;BA.debugLine="AddMsg(EditText2.Text, smsDatetime, TxtContacts.";
_addmsg(mostCurrent._edittext2.getText(),_smsdatetime,mostCurrent._txtcontacts.getText());
 };
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="End Sub";
return "";
}
public static String  _lbldate_click() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbldate_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lbldate_click", null);
anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog _dd = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub LblDate_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim dd As DateDialog";
_dd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog();
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="If dd.Show(\"Select date to send message\", \"\", \"Ok";
if (_dd.Show("Select date to send message","","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null))==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="alarmdate = dd.DateTicks";
_alarmdate = _dd.getDateTicks();
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="LblDate.Text = DateTime.Date(alarmdate)";
mostCurrent._lbldate.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Date(_alarmdate)));
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="boolDate = True";
_booldate = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="End Sub";
return "";
}
public static String  _lbltime_click() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lbltime_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lbltime_click", null);
int _alarmhours = 0;
int _alarmminutes = 0;
anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog _td = null;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub LblTime_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim alarmHours, alarmMinutes As Int";
_alarmhours = 0;
_alarmminutes = 0;
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Dim td As TimeDialog";
_td = new anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="td.Hour = alarmHours";
_td.setHour(_alarmhours);
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="td.Minute = alarmMinutes";
_td.setMinute(_alarmminutes);
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="If td.Show(\"Select time to send message\", \"\", \"Ok";
if (_td.Show("Select time to send message","","Ok","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null))==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="alarmHours = td.Hour";
_alarmhours = _td.getHour();
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="alarmMinutes = td.Minute";
_alarmminutes = _td.getMinute();
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="alarmtime =  td.Hour * DateTime.TicksPerHour + t";
_alarmtime = (long) (_td.getHour()*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour+_td.getMinute()*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=1835019;
 //BA.debugLineNum = 1835019;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="LblTime.Text = DateTime.Time(alarmtime)";
mostCurrent._lbltime.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(_alarmtime)));
RDebugUtils.currentLine=1835022;
 //BA.debugLineNum = 1835022;BA.debugLine="boolTime = True";
_booltime = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=1835024;
 //BA.debugLineNum = 1835024;BA.debugLine="End Sub";
return "";
}
public static String  _lstcontacts_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lstcontacts_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "lstcontacts_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub LstContacts_ItemClick (Position As Int, Value";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="TxtContacts.Text = Value";
mostCurrent._txtcontacts.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="PnlContact.Visible = False";
mostCurrent._pnlcontact.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="End Sub";
return "";
}
public static String  _reschedule() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "reschedule"))
	return (String) Debug.delegate(mostCurrent.activityBA, "reschedule", null);
anywheresoftware.b4a.objects.collections.Map _map = null;
long _alarm = 0L;
int _d = 0;
int _h = 0;
int _m = 0;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub reschedule";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Dim map As Map";
_map = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="map.Initialize";
_map.Initialize();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="map = sqlGetClosest";
_map = _sqlgetclosest();
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Dim alarm As Long = map.Get(\"Date\")";
_alarm = BA.ObjectToLongNumber(_map.Get((Object)("Date")));
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="Log(alarm)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_alarm));
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="If alarm < DateTime.Now Then alarm = DateTime.Add";
if (_alarm<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
_alarm = anywheresoftware.b4a.keywords.Common.DateTime.Add(_alarm,(int) (0),(int) (0),(int) (1));};
RDebugUtils.currentLine=2228235;
 //BA.debugLineNum = 2228235;BA.debugLine="Log(DateTime.Date(alarm) & \" \" & DateTime.Time(al";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.DateTime.Date(_alarm)+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(_alarm));
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="Dim d, h, m As Int";
_d = 0;
_h = 0;
_m = 0;
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="d = Floor((alarm - DateTime.Now) / DateTime.Ticks";
_d = (int) (anywheresoftware.b4a.keywords.Common.Floor((_alarm-anywheresoftware.b4a.keywords.Common.DateTime.getNow())/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerDay));
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="h = Floor((alarm - DateTime.Add(DateTime.Now, 0,";
_h = (int) (anywheresoftware.b4a.keywords.Common.Floor((_alarm-anywheresoftware.b4a.keywords.Common.DateTime.Add(anywheresoftware.b4a.keywords.Common.DateTime.getNow(),(int) (0),(int) (0),_d))/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour));
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="m = ((alarm - DateTime.Now) - h * DateTime.TicksP";
_m = (int) (((_alarm-anywheresoftware.b4a.keywords.Common.DateTime.getNow())-_h*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=2228243;
 //BA.debugLineNum = 2228243;BA.debugLine="ToastMessageShow(\"SMS will be sent after: \" & Num";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("SMS will be sent after: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_d,(int) (2),(int) (0))+" day(s) and "+anywheresoftware.b4a.keywords.Common.NumberFormat(_h,(int) (2),(int) (0))+" hour(s) and "+anywheresoftware.b4a.keywords.Common.NumberFormat(_m,(int) (2),(int) (0))+" minute(s)"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2228244;
 //BA.debugLineNum = 2228244;BA.debugLine="StartServiceAt(Messaging, alarm, True)";
anywheresoftware.b4a.keywords.Common.StartServiceAt(processBA,(Object)(mostCurrent._messaging.getObject()),_alarm,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2228245;
 //BA.debugLineNum = 2228245;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _sqlgetclosest() throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sqlgetclosest"))
	return (anywheresoftware.b4a.objects.collections.Map) Debug.delegate(mostCurrent.activityBA, "sqlgetclosest", null);
anywheresoftware.b4a.objects.collections.Map _map = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub sqlGetClosest As Map";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim map As Map";
_map = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim cursor As Cursor";
_cursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="map.Initialize";
_map.Initialize();
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="cursor = Messaging.SQL1.ExecQuery(\"SELECT * FROM";
_cursor.setObject((android.database.Cursor)(mostCurrent._messaging._sql1.ExecQuery("SELECT * FROM queue WHERE Status = 1 ORDER BY DateTime ASC")));
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="If cursor.RowCount > 0 Then";
if (_cursor.getRowCount()>0) { 
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="cursor.Position = 0";
_cursor.setPosition((int) (0));
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="map.Put(\"id\", cursor.GetInt(\"ID\"))";
_map.Put((Object)("id"),(Object)(_cursor.GetInt("ID")));
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="map.Put(\"Contact\", cursor.GetString(\"Contact\"))";
_map.Put((Object)("Contact"),(Object)(_cursor.GetString("Contact")));
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="map.Put(\"Message\", cursor.GetString(\"Message\"))";
_map.Put((Object)("Message"),(Object)(_cursor.GetString("Message")));
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="map.Put(\"Date\", cursor.GetString(\"DateTime\"))";
_map.Put((Object)("Date"),(Object)(_cursor.GetString("DateTime")));
 };
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="Log(\"map is \" & CRLF & map)";
anywheresoftware.b4a.keywords.Common.Log("map is "+anywheresoftware.b4a.keywords.Common.CRLF+BA.ObjectToString(_map));
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="cursor.Close";
_cursor.Close();
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="Return map";
if (true) return _map;
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="End Sub";
return null;
}
public static String  _txtcontacts_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="add";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcontacts_textchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "txtcontacts_textchanged", new Object[] {_old,_new});
int _i = 0;
b4a.example.contactsutils._cucontact _c = null;
b4a.example.contactsutils._cuphone _p = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub TxtContacts_TextChanged (Old As String, New As";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If New.Trim.Length > 0 Then";
if (_new.trim().length()>0) { 
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="PnlContact.Visible = True";
mostCurrent._pnlcontact.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="LstContacts.Clear";
mostCurrent._lstcontacts.Clear();
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="Dim cu As ContactsUtils";
mostCurrent._cu = new b4a.example.contactsutils();
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="cu.Initialize";
mostCurrent._cu._initialize(processBA);
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="Clist = cu.FindContactsByName(New,False, True)";
mostCurrent._clist = mostCurrent._cu._findcontactsbyname(_new,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="For i = 0 To Clist.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._clist.getSize()-1);
_i = (int) (0) ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="Dim c As cuContact = Clist.Get(i)";
_c = (b4a.example.contactsutils._cucontact)(mostCurrent._clist.Get(_i));
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="For Each p As cuPhone In cu.GetPhones(c.Id)";
{
final anywheresoftware.b4a.BA.IterableList group9 = mostCurrent._cu._getphones(_c.Id);
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_p = (b4a.example.contactsutils._cuphone)(group9.Get(index9));
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="LstContacts.AddTwoLines2(c.DisplayName,p.Numbe";
mostCurrent._lstcontacts.AddTwoLines2(BA.ObjectToCharSequence(_c.DisplayName),BA.ObjectToCharSequence(_p.Number),(Object)(_p.Number));
 }
};
 }
};
 }else {
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="PnlContact.Visible= False";
mostCurrent._pnlcontact.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="End Sub";
return "";
}
}