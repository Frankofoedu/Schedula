package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class messaging_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim SQL1 As SQL";
messaging._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reschedule() throws Exception{
try {
		Debug.PushSubsStack("reschedule (messaging) ","messaging",2,messaging.processBA,messaging.mostCurrent,24);
if (RapidSub.canDelegate("reschedule")) return b4a.example.messaging.remoteMe.runUserSub(false, "messaging","reschedule");
 BA.debugLineNum = 24;BA.debugLine="Sub reschedule";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (messaging) ","messaging",2,messaging.processBA,messaging.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) return b4a.example.messaging.remoteMe.runUserSub(false, "messaging","service_create");
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (messaging) ","messaging",2,messaging.processBA,messaging.mostCurrent,20);
if (RapidSub.canDelegate("service_destroy")) return b4a.example.messaging.remoteMe.runUserSub(false, "messaging","service_destroy");
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (messaging) ","messaging",2,messaging.processBA,messaging.mostCurrent,16);
if (RapidSub.canDelegate("service_start")) return b4a.example.messaging.remoteMe.runUserSub(false, "messaging","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}