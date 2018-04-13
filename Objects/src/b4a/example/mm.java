package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class mm extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.mm");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.mm.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbase = null;
public int _defaultcolorconstant = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.messaging _messaging = null;
public b4a.example.add _add = null;
public String  _class_globals(b4a.example.mm __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="mm";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="Private mBase As Panel";
_mbase = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
_defaultcolorconstant = (int) (-984833);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(b4a.example.mm __ref,anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="mm";
if (Debug.shouldDelegate(ba, "designercreateview"))
	return (String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props});
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="mBase = Base";
__ref._mbase = _base;
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _getbase(b4a.example.mm __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="mm";
if (Debug.shouldDelegate(ba, "getbase"))
	return (anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(ba, "getbase", null);
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Public Sub GetBase As Panel";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Return mBase";
if (true) return __ref._mbase;
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="End Sub";
return null;
}
public String  _initialize(b4a.example.mm __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="mm";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname});
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="mEventName = EventName";
__ref._meventname = _eventname;
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="mCallBack = Callback";
__ref._mcallback = _callback;
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="End Sub";
return "";
}
}