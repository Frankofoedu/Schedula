package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) return b4a.example.add.remoteMe.runUserSub(false, "add","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"2\")";
Debug.ShouldStop(4);
add.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("2")),add.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="cu.Initialize";
Debug.ShouldStop(8);
add.mostCurrent._cu.runVoidMethod ("_initialize",add.processBA);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.add.remoteMe.runUserSub(false, "add","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.add.remoteMe.runUserSub(false, "add","activity_resume");
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addmsg(RemoteObject _sms,RemoteObject _daytime,RemoteObject _phoneno) throws Exception{
try {
		Debug.PushSubsStack("AddMsg (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,133);
if (RapidSub.canDelegate("addmsg")) return b4a.example.add.remoteMe.runUserSub(false, "add","addmsg", _sms, _daytime, _phoneno);
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _curs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _status = RemoteObject.createImmutable(0);
Debug.locals.put("sms", _sms);
Debug.locals.put("daytime", _daytime);
Debug.locals.put("phoneno", _phoneno);
 BA.debugLineNum = 133;BA.debugLine="Sub AddMsg(sms As String,daytime As Long , phoneno";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Dim query As String";
Debug.ShouldStop(32);
_query = RemoteObject.createImmutable("");Debug.locals.put("query", _query);
 BA.debugLineNum = 135;BA.debugLine="Dim curs As Cursor";
Debug.ShouldStop(64);
_curs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("curs", _curs);
 BA.debugLineNum = 136;BA.debugLine="Dim status As Int = 1";
Debug.ShouldStop(128);
_status = BA.numberCast(int.class, 1);Debug.locals.put("status", _status);Debug.locals.put("status", _status);
 BA.debugLineNum = 138;BA.debugLine="query = \"SELECT * FROM queue WHERE sms = ? AND ph";
Debug.ShouldStop(512);
_query = BA.ObjectToString("SELECT * FROM queue WHERE sms = ? AND phoneno = ?");Debug.locals.put("query", _query);
 BA.debugLineNum = 139;BA.debugLine="curs = Messaging.SQL1.ExecQuery2(query, Array As";
Debug.ShouldStop(1024);
_curs.setObject(add.mostCurrent._messaging._sql1.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {_sms,_phoneno}))));
 BA.debugLineNum = 141;BA.debugLine="If curs.RowCount > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_curs.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 142;BA.debugLine="If Msgbox2(\"This sms to the same person already";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",add.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToCharSequence("This sms to the same person already exist in the queue. Do you still want to send?")),(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((add.mostCurrent.__c.getField(false,"Null"))),add.mostCurrent.activityBA),BA.numberCast(double.class, add.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 143;BA.debugLine="query = \"INSERT INTO queue VALUES (NULL, '\" & p";
Debug.ShouldStop(16384);
_query = RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO queue VALUES (NULL, '"),_phoneno,RemoteObject.createImmutable("', '"),_sms,RemoteObject.createImmutable("', '"),_daytime,RemoteObject.createImmutable("', '"),_status,RemoteObject.createImmutable("')"));Debug.locals.put("query", _query);
 BA.debugLineNum = 144;BA.debugLine="Messaging.SQL1.ExecNonQuery(query)";
Debug.ShouldStop(32768);
add.mostCurrent._messaging._sql1.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 145;BA.debugLine="ToastMessageShow(\"SMS added to QUEUE\", True)";
Debug.ShouldStop(65536);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("SMS added to QUEUE")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 147;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 }else {
 BA.debugLineNum = 150;BA.debugLine="query = \"INSERT INTO queue VALUES (NULL, '\" & ph";
Debug.ShouldStop(2097152);
_query = RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO queue VALUES (NULL, '"),_phoneno,RemoteObject.createImmutable("', '"),_sms,RemoteObject.createImmutable("', '"),_daytime,RemoteObject.createImmutable("', '"),_status,RemoteObject.createImmutable("')"));Debug.locals.put("query", _query);
 BA.debugLineNum = 151;BA.debugLine="Messaging.SQL1.ExecNonQuery(query)";
Debug.ShouldStop(4194304);
add.mostCurrent._messaging._sql1.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 152;BA.debugLine="ToastMessageShow(\"SMS added to QUEUE\", True)";
Debug.ShouldStop(8388608);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("SMS added to QUEUE")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 155;BA.debugLine="curs.Close";
Debug.ShouldStop(67108864);
_curs.runVoidMethod ("Close");
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim alarmtime, alarmdate As Long";
add._alarmtime = RemoteObject.createImmutable(0L);
add._alarmdate = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 16;BA.debugLine="Dim boolDate As Boolean = False";
add._booldate = add.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 17;BA.debugLine="Dim boolTime As Boolean = False";
add._booltime = add.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 19;BA.debugLine="Private LblDate As Label";
add.mostCurrent._lbldate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private LblTime As Label";
add.mostCurrent._lbltime = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private TxtContacts As EditText";
add.mostCurrent._txtcontacts = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private LstContacts As ListView";
add.mostCurrent._lstcontacts = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private PnlContact As Panel";
add.mostCurrent._pnlcontact = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim cu As ContactsUtils";
add.mostCurrent._cu = RemoteObject.createNew ("b4a.example.contactsutils");
 //BA.debugLineNum = 26;BA.debugLine="Dim selected As Boolean";
add._selected = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 27;BA.debugLine="Dim Clist As List";
add.mostCurrent._clist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 28;BA.debugLine="Private panSend As Panel";
add.mostCurrent._pansend = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private EditText2 As EditText";
add.mostCurrent._edittext2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imageview4_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView4_Click (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,105);
if (RapidSub.canDelegate("imageview4_click")) return b4a.example.add.remoteMe.runUserSub(false, "add","imageview4_click");
RemoteObject _smsdatetime = RemoteObject.createImmutable(0L);
 BA.debugLineNum = 105;BA.debugLine="Sub ImageView4_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 107;BA.debugLine="If TxtContacts.Text.Trim.Length = 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",add.mostCurrent._txtcontacts.runMethod(true,"getText").runMethod(true,"trim").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 108;BA.debugLine="ToastMessageShow(\"please enter contact number\",";
Debug.ShouldStop(2048);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("please enter contact number")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 109;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 112;BA.debugLine="If boolDate = False Or boolTime = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",add._booldate,add.mostCurrent.__c.getField(true,"False")) || RemoteObject.solveBoolean("=",add._booltime,add.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 113;BA.debugLine="ToastMessageShow(\"Enter date and time\",True)";
Debug.ShouldStop(65536);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Enter date and time")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 114;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 117;BA.debugLine="If EditText2.Text.Trim.Length = 1 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",add.mostCurrent._edittext2.runMethod(true,"getText").runMethod(true,"trim").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 118;BA.debugLine="ToastMessageShow(\"Your sms is empty\",True)";
Debug.ShouldStop(2097152);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Your sms is empty")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 119;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 122;BA.debugLine="Dim smsDatetime As Long = alarmdate + alarmtime";
Debug.ShouldStop(33554432);
_smsdatetime = RemoteObject.solve(new RemoteObject[] {add._alarmdate,add._alarmtime}, "+",1, 2);Debug.locals.put("smsDatetime", _smsdatetime);Debug.locals.put("smsDatetime", _smsdatetime);
 BA.debugLineNum = 124;BA.debugLine="If smsDatetime < DateTime.Now Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",_smsdatetime,BA.numberCast(double.class, add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))) { 
 BA.debugLineNum = 125;BA.debugLine="ToastMessageShow(\"This time is past\",True)";
Debug.ShouldStop(268435456);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("This time is past")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 127;BA.debugLine="AddMsg(EditText2.Text, smsDatetime, TxtContacts.";
Debug.ShouldStop(1073741824);
_addmsg(add.mostCurrent._edittext2.runMethod(true,"getText"),_smsdatetime,add.mostCurrent._txtcontacts.runMethod(true,"getText"));
 };
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbldate_click() throws Exception{
try {
		Debug.PushSubsStack("LblDate_Click (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,67);
if (RapidSub.canDelegate("lbldate_click")) return b4a.example.add.remoteMe.runUserSub(false, "add","lbldate_click");
RemoteObject _dd = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");
 BA.debugLineNum = 67;BA.debugLine="Sub LblDate_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim dd As DateDialog";
Debug.ShouldStop(8);
_dd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.DateDialog");Debug.locals.put("dd", _dd);
 BA.debugLineNum = 70;BA.debugLine="If dd.Show(\"Select date to send message\", \"\", \"Ok";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_dd.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("Select date to send message")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),add.mostCurrent.activityBA,(Object)((add.mostCurrent.__c.getField(false,"Null")))),BA.numberCast(double.class, add.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 71;BA.debugLine="alarmdate = dd.DateTicks";
Debug.ShouldStop(64);
add._alarmdate = _dd.runMethod(true,"getDateTicks");
 BA.debugLineNum = 72;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(128);
add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 73;BA.debugLine="LblDate.Text = DateTime.Date(alarmdate)";
Debug.ShouldStop(256);
add.mostCurrent._lbldate.runMethod(true,"setText",BA.ObjectToCharSequence(add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(add._alarmdate))));
 BA.debugLineNum = 74;BA.debugLine="boolDate = True";
Debug.ShouldStop(512);
add._booldate = add.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lbltime_click() throws Exception{
try {
		Debug.PushSubsStack("LblTime_Click (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,49);
if (RapidSub.canDelegate("lbltime_click")) return b4a.example.add.remoteMe.runUserSub(false, "add","lbltime_click");
RemoteObject _alarmhours = RemoteObject.createImmutable(0);
RemoteObject _alarmminutes = RemoteObject.createImmutable(0);
RemoteObject _td = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");
 BA.debugLineNum = 49;BA.debugLine="Sub LblTime_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Dim alarmHours, alarmMinutes As Int";
Debug.ShouldStop(131072);
_alarmhours = RemoteObject.createImmutable(0);Debug.locals.put("alarmHours", _alarmhours);
_alarmminutes = RemoteObject.createImmutable(0);Debug.locals.put("alarmMinutes", _alarmminutes);
 BA.debugLineNum = 52;BA.debugLine="Dim td As TimeDialog";
Debug.ShouldStop(524288);
_td = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");Debug.locals.put("td", _td);
 BA.debugLineNum = 53;BA.debugLine="td.Hour = alarmHours";
Debug.ShouldStop(1048576);
_td.runMethod(true,"setHour",_alarmhours);
 BA.debugLineNum = 54;BA.debugLine="td.Minute = alarmMinutes";
Debug.ShouldStop(2097152);
_td.runMethod(true,"setMinute",_alarmminutes);
 BA.debugLineNum = 55;BA.debugLine="If td.Show(\"Select time to send message\", \"\", \"Ok";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_td.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("Select time to send message")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),add.mostCurrent.activityBA,(Object)((add.mostCurrent.__c.getField(false,"Null")))),BA.numberCast(double.class, add.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 56;BA.debugLine="alarmHours = td.Hour";
Debug.ShouldStop(8388608);
_alarmhours = _td.runMethod(true,"getHour");Debug.locals.put("alarmHours", _alarmhours);
 BA.debugLineNum = 57;BA.debugLine="alarmMinutes = td.Minute";
Debug.ShouldStop(16777216);
_alarmminutes = _td.runMethod(true,"getMinute");Debug.locals.put("alarmMinutes", _alarmminutes);
 BA.debugLineNum = 59;BA.debugLine="alarmtime =  td.Hour * DateTime.TicksPerHour + t";
Debug.ShouldStop(67108864);
add._alarmtime = RemoteObject.solve(new RemoteObject[] {_td.runMethod(true,"getHour"),add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour"),_td.runMethod(true,"getMinute"),add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "*+*",1, 2);
 BA.debugLineNum = 60;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
Debug.ShouldStop(134217728);
add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 61;BA.debugLine="LblTime.Text = DateTime.Time(alarmtime)";
Debug.ShouldStop(268435456);
add.mostCurrent._lbltime.runMethod(true,"setText",BA.ObjectToCharSequence(add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(add._alarmtime))));
 BA.debugLineNum = 63;BA.debugLine="boolTime = True";
Debug.ShouldStop(1073741824);
add._booltime = add.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lstcontacts_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("LstContacts_ItemClick (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,99);
if (RapidSub.canDelegate("lstcontacts_itemclick")) return b4a.example.add.remoteMe.runUserSub(false, "add","lstcontacts_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 99;BA.debugLine="Sub LstContacts_ItemClick (Position As Int, Value";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="TxtContacts.Text = Value";
Debug.ShouldStop(8);
add.mostCurrent._txtcontacts.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 101;BA.debugLine="PnlContact.Visible = False";
Debug.ShouldStop(16);
add.mostCurrent._pnlcontact.runMethod(true,"setVisible",add.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reschedule() throws Exception{
try {
		Debug.PushSubsStack("reschedule (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,159);
if (RapidSub.canDelegate("reschedule")) return b4a.example.add.remoteMe.runUserSub(false, "add","reschedule");
RemoteObject _map = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _alarm = RemoteObject.createImmutable(0L);
RemoteObject _d = RemoteObject.createImmutable(0);
RemoteObject _h = RemoteObject.createImmutable(0);
RemoteObject _m = RemoteObject.createImmutable(0);
 BA.debugLineNum = 159;BA.debugLine="Sub reschedule";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="Dim map As Map";
Debug.ShouldStop(-2147483648);
_map = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("map", _map);
 BA.debugLineNum = 161;BA.debugLine="map.Initialize";
Debug.ShouldStop(1);
_map.runVoidMethod ("Initialize");
 BA.debugLineNum = 162;BA.debugLine="map = sqlGetClosest";
Debug.ShouldStop(2);
_map = _sqlgetclosest();Debug.locals.put("map", _map);
 BA.debugLineNum = 164;BA.debugLine="Dim alarm As Long = map.Get(\"Date\")";
Debug.ShouldStop(8);
_alarm = BA.numberCast(long.class, _map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Date")))));Debug.locals.put("alarm", _alarm);Debug.locals.put("alarm", _alarm);
 BA.debugLineNum = 166;BA.debugLine="Log(alarm)";
Debug.ShouldStop(32);
add.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_alarm)));
 BA.debugLineNum = 168;BA.debugLine="If alarm < DateTime.Now Then alarm = DateTime.Add";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("<",_alarm,BA.numberCast(double.class, add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))) { 
_alarm = add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_alarm),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("alarm", _alarm);};
 BA.debugLineNum = 170;BA.debugLine="Log(DateTime.Date(alarm) & \" \" & DateTime.Time(al";
Debug.ShouldStop(512);
add.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_alarm)),RemoteObject.createImmutable(" "),add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_alarm)))));
 BA.debugLineNum = 172;BA.debugLine="Dim d, h, m As Int";
Debug.ShouldStop(2048);
_d = RemoteObject.createImmutable(0);Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable(0);Debug.locals.put("h", _h);
_m = RemoteObject.createImmutable(0);Debug.locals.put("m", _m);
 BA.debugLineNum = 174;BA.debugLine="d = Floor((alarm - DateTime.Now) / DateTime.Ticks";
Debug.ShouldStop(8192);
_d = BA.numberCast(int.class, add.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alarm,add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")}, "-",1, 2)),add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "/",0, 0))));Debug.locals.put("d", _d);
 BA.debugLineNum = 175;BA.debugLine="h = Floor((alarm - DateTime.Add(DateTime.Now, 0,";
Debug.ShouldStop(16384);
_h = BA.numberCast(int.class, add.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alarm,add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_d))}, "-",1, 2)),add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "/",0, 0))));Debug.locals.put("h", _h);
 BA.debugLineNum = 176;BA.debugLine="m = ((alarm - DateTime.Now) - h * DateTime.TicksP";
Debug.ShouldStop(32768);
_m = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alarm,add.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")}, "-",1, 2)),_h,add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "-*",1, 2)),add.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "/",0, 0));Debug.locals.put("m", _m);
 BA.debugLineNum = 178;BA.debugLine="ToastMessageShow(\"SMS will be sent after: \" & Num";
Debug.ShouldStop(131072);
add.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("SMS will be sent after: "),add.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _d)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" day(s) and "),add.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _h)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" hour(s) and "),add.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _m)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" minute(s)")))),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 179;BA.debugLine="StartServiceAt(Messaging, alarm, True)";
Debug.ShouldStop(262144);
add.mostCurrent.__c.runVoidMethod ("StartServiceAt",add.processBA,(Object)((add.mostCurrent._messaging.getObject())),(Object)(_alarm),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 180;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqlgetclosest() throws Exception{
try {
		Debug.PushSubsStack("sqlGetClosest (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,183);
if (RapidSub.canDelegate("sqlgetclosest")) return b4a.example.add.remoteMe.runUserSub(false, "add","sqlgetclosest");
RemoteObject _map = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 BA.debugLineNum = 183;BA.debugLine="Sub sqlGetClosest As Map";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="Dim map As Map";
Debug.ShouldStop(8388608);
_map = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("map", _map);
 BA.debugLineNum = 185;BA.debugLine="Dim cursor As Cursor";
Debug.ShouldStop(16777216);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cursor", _cursor);
 BA.debugLineNum = 187;BA.debugLine="map.Initialize";
Debug.ShouldStop(67108864);
_map.runVoidMethod ("Initialize");
 BA.debugLineNum = 189;BA.debugLine="cursor = Messaging.SQL1.ExecQuery(\"SELECT * FROM";
Debug.ShouldStop(268435456);
_cursor.setObject(add.mostCurrent._messaging._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT * FROM queue WHERE Status = 1 ORDER BY DateTime ASC"))));
 BA.debugLineNum = 191;BA.debugLine="If cursor.RowCount > 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean(">",_cursor.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 192;BA.debugLine="cursor.Position = 0";
Debug.ShouldStop(-2147483648);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 194;BA.debugLine="map.Put(\"id\", cursor.GetInt(\"ID\"))";
Debug.ShouldStop(2);
_map.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("id"))),(Object)((_cursor.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("ID"))))));
 BA.debugLineNum = 195;BA.debugLine="map.Put(\"Contact\", cursor.GetString(\"Contact\"))";
Debug.ShouldStop(4);
_map.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Contact"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Contact"))))));
 BA.debugLineNum = 196;BA.debugLine="map.Put(\"Message\", cursor.GetString(\"Message\"))";
Debug.ShouldStop(8);
_map.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Message"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Message"))))));
 BA.debugLineNum = 197;BA.debugLine="map.Put(\"Date\", cursor.GetString(\"DateTime\"))";
Debug.ShouldStop(16);
_map.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Date"))),(Object)((_cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("DateTime"))))));
 };
 BA.debugLineNum = 201;BA.debugLine="Log(\"map is \" & CRLF & map)";
Debug.ShouldStop(256);
add.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("map is "),add.mostCurrent.__c.getField(true,"CRLF"),_map)));
 BA.debugLineNum = 202;BA.debugLine="cursor.Close";
Debug.ShouldStop(512);
_cursor.runVoidMethod ("Close");
 BA.debugLineNum = 203;BA.debugLine="Return map";
Debug.ShouldStop(1024);
if (true) return _map;
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcontacts_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("TxtContacts_TextChanged (add) ","add",3,add.mostCurrent.activityBA,add.mostCurrent,78);
if (RapidSub.canDelegate("txtcontacts_textchanged")) return b4a.example.add.remoteMe.runUserSub(false, "add","txtcontacts_textchanged", _old, _new);
int _i = 0;
RemoteObject _c = RemoteObject.declareNull("b4a.example.contactsutils._cucontact");
RemoteObject _p = RemoteObject.declareNull("b4a.example.contactsutils._cuphone");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 78;BA.debugLine="Sub TxtContacts_TextChanged (Old As String, New As";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If New.Trim.Length > 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"trim").runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 81;BA.debugLine="PnlContact.Visible = True";
Debug.ShouldStop(65536);
add.mostCurrent._pnlcontact.runMethod(true,"setVisible",add.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 82;BA.debugLine="LstContacts.Clear";
Debug.ShouldStop(131072);
add.mostCurrent._lstcontacts.runVoidMethod ("Clear");
 BA.debugLineNum = 84;BA.debugLine="Dim cu As ContactsUtils";
Debug.ShouldStop(524288);
add.mostCurrent._cu = RemoteObject.createNew ("b4a.example.contactsutils");
 BA.debugLineNum = 85;BA.debugLine="cu.Initialize";
Debug.ShouldStop(1048576);
add.mostCurrent._cu.runVoidMethod ("_initialize",add.processBA);
 BA.debugLineNum = 86;BA.debugLine="Clist = cu.FindContactsByName(New,False, True)";
Debug.ShouldStop(2097152);
add.mostCurrent._clist = add.mostCurrent._cu.runMethod(false,"_findcontactsbyname",(Object)(_new),(Object)(add.mostCurrent.__c.getField(true,"False")),(Object)(add.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 88;BA.debugLine="For i = 0 To Clist.Size - 1";
Debug.ShouldStop(8388608);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {add.mostCurrent._clist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 89;BA.debugLine="Dim c As cuContact = Clist.Get(i)";
Debug.ShouldStop(16777216);
_c = (add.mostCurrent._clist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 90;BA.debugLine="For Each p As cuPhone In cu.GetPhones(c.Id)";
Debug.ShouldStop(33554432);
{
final RemoteObject group9 = add.mostCurrent._cu.runMethod(false,"_getphones",(Object)(_c.getField(true,"Id")));
final int groupLen9 = group9.runMethod(true,"getSize").<Integer>get()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_p = (group9.runMethod(false,"Get",index9));Debug.locals.put("p", _p);
Debug.locals.put("p", _p);
 BA.debugLineNum = 91;BA.debugLine="LstContacts.AddTwoLines2(c.DisplayName,p.Numbe";
Debug.ShouldStop(67108864);
add.mostCurrent._lstcontacts.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToCharSequence(_c.getField(true,"DisplayName"))),(Object)(BA.ObjectToCharSequence(_p.getField(true,"Number"))),(Object)((_p.getField(true,"Number"))));
 }
}Debug.locals.put("p", _p);
;
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 95;BA.debugLine="PnlContact.Visible= False";
Debug.ShouldStop(1073741824);
add.mostCurrent._pnlcontact.runMethod(true,"setVisible",add.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}