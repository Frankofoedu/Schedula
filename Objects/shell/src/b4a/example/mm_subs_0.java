package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class mm_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private mEventName As String 'ignore";
mm._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",mm._meventname);
 //BA.debugLineNum = 11;BA.debugLine="Private mCallBack As Object 'ignore";
mm._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",mm._mcallback);
 //BA.debugLineNum = 12;BA.debugLine="Private mBase As Panel";
mm._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_mbase",mm._mbase);
 //BA.debugLineNum = 13;BA.debugLine="Private Const DefaultColorConstant As Int = -9848";
mm._defaultcolorconstant = BA.numberCast(int.class, -(double) (0 + 984833));__ref.setField("_defaultcolorconstant",mm._defaultcolorconstant);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (mm) ","mm",5,__ref.getField(false, "ba"),__ref,21);
if (RapidSub.canDelegate("designercreateview")) return __ref.runUserSub(false, "mm","designercreateview", __ref, _base, _lbl, _props);
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 21;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="mBase = Base";
Debug.ShouldStop(2097152);
__ref.setField ("_mbase",_base);
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getbase(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBase (mm) ","mm",5,__ref.getField(false, "ba"),__ref,26);
if (RapidSub.canDelegate("getbase")) return __ref.runUserSub(false, "mm","getbase", __ref);
 BA.debugLineNum = 26;BA.debugLine="Public Sub GetBase As Panel";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Return mBase";
Debug.ShouldStop(67108864);
if (true) return __ref.getField(false,"_mbase");
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (mm) ","mm",5,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "mm","initialize", __ref, _ba, _callback, _eventname);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(65536);
__ref.setField ("_meventname",_eventname);
 BA.debugLineNum = 18;BA.debugLine="mCallBack = Callback";
Debug.ShouldStop(131072);
__ref.setField ("_mcallback",_callback);
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}