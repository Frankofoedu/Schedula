package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 40;BA.debugLine="timer1.Initialize(\"Timer1\",3000)";
Debug.ShouldStop(128);
main._timer1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("Timer1")),(Object)(BA.numberCast(long.class, 3000)));
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(256);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="TabStrip1.LoadLayout(\"queue\",\"QUEUE\")";
Debug.ShouldStop(512);
main.mostCurrent._tabstrip1.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("queue")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("QUEUE"))));
 BA.debugLineNum = 43;BA.debugLine="TabStrip1.LoadLayout(\"sent\",\"SENT\")";
Debug.ShouldStop(1024);
main.mostCurrent._tabstrip1.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("sent")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("SENT"))));
 BA.debugLineNum = 45;BA.debugLine="ScrlvQueue.Panel.Width = ScrlvQueue.Width";
Debug.ShouldStop(4096);
main.mostCurrent._scrlvqueue.runMethod(false,"getPanel").runMethod(true,"setWidth",main.mostCurrent._scrlvqueue.runMethod(true,"getWidth"));
 BA.debugLineNum = 46;BA.debugLine="ScrlvSent.Panel.Width = ScrlvSent.Width";
Debug.ShouldStop(8192);
main.mostCurrent._scrlvsent.runMethod(false,"getPanel").runMethod(true,"setWidth",main.mostCurrent._scrlvsent.runMethod(true,"getWidth"));
 BA.debugLineNum = 47;BA.debugLine="ScrlvQueue.Panel.Height = ( Activity.Height - 60)";
Debug.ShouldStop(16384);
main.mostCurrent._scrlvqueue.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),RemoteObject.createImmutable(60)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0)));
 BA.debugLineNum = 48;BA.debugLine="ScrlvQueue.Color = Colors.green";
Debug.ShouldStop(32768);
main.mostCurrent._scrlvqueue.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 51;BA.debugLine="timer1.Enabled = True";
Debug.ShouldStop(262144);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 53;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1048576);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 54;BA.debugLine="File.Delete(File.DirInternal, \"Schedule.db\") ' o";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("Schedule.db")));
 BA.debugLineNum = 57;BA.debugLine="If File.Exists(File.DirInternal, \"Schedule.db\")";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("Schedule.db"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 59;BA.debugLine="Messaging.SQL1.Initialize(File.DirInternal, \"Sc";
Debug.ShouldStop(67108864);
main.mostCurrent._messaging._sql1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("Schedule.db")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 61;BA.debugLine="CreateDataBase";
Debug.ShouldStop(268435456);
_createdatabase();
 };
 };
 BA.debugLineNum = 65;BA.debugLine="For Each lbl As Label In GetAllTabLabels(TabStrip";
Debug.ShouldStop(1);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
{
final RemoteObject group17 = _getalltablabels(main.mostCurrent._tabstrip1);
final int groupLen17 = group17.runMethod(true,"getSize").<Integer>get()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_lbl.setObject(group17.runMethod(false,"Get",index17));
Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 66;BA.debugLine="lbl.Width = (PnlHome.Width)/2";
Debug.ShouldStop(2);
_lbl.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(main.mostCurrent._pnlhome.runMethod(true,"getWidth")),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }
}Debug.locals.put("lbl", _lbl);
;
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,75);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addmsgpanel(RemoteObject _scv,RemoteObject _test,RemoteObject _xtext,RemoteObject _ytext,RemoteObject _ztext) throws Exception{
try {
		Debug.PushSubsStack("AddMsgPanel (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("addmsgpanel")) return b4a.example.main.remoteMe.runUserSub(false, "main","addmsgpanel", _scv, _test, _xtext, _ytext, _ztext);
RemoteObject _panel0 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _imgv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _iconlbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _j = RemoteObject.createImmutable(0);
RemoteObject _k = RemoteObject.createImmutable(0);
Debug.locals.put("scv", _scv);
Debug.locals.put("test", _test);
Debug.locals.put("xtext", _xtext);
Debug.locals.put("ytext", _ytext);
Debug.locals.put("ztext", _ztext);
 BA.debugLineNum = 111;BA.debugLine="Sub AddMsgPanel(scv As ScrollView, test As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Dim panel0 As Panel";
Debug.ShouldStop(32768);
_panel0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("panel0", _panel0);
 BA.debugLineNum = 113;BA.debugLine="panel0 = scv.Panel";
Debug.ShouldStop(65536);
_panel0 = _scv.runMethod(false,"getPanel");Debug.locals.put("panel0", _panel0);
 BA.debugLineNum = 116;BA.debugLine="Dim panel1 As Panel";
Debug.ShouldStop(524288);
_panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("panel1", _panel1);
 BA.debugLineNum = 117;BA.debugLine="Dim label1 As Label";
Debug.ShouldStop(1048576);
_label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("label1", _label1);
 BA.debugLineNum = 118;BA.debugLine="Dim label2 As Label";
Debug.ShouldStop(2097152);
_label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("label2", _label2);
 BA.debugLineNum = 119;BA.debugLine="Dim label3 As Label";
Debug.ShouldStop(4194304);
_label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("label3", _label3);
 BA.debugLineNum = 120;BA.debugLine="Dim label4 As Label";
Debug.ShouldStop(8388608);
_label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("label4", _label4);
 BA.debugLineNum = 121;BA.debugLine="Dim imgv As ImageView";
Debug.ShouldStop(16777216);
_imgv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("imgv", _imgv);
 BA.debugLineNum = 122;BA.debugLine="Dim iconlbl As Label";
Debug.ShouldStop(33554432);
_iconlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("iconlbl", _iconlbl);
 BA.debugLineNum = 124;BA.debugLine="panel1.Initialize(\"Panel1\")";
Debug.ShouldStop(134217728);
_panel1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel1")));
 BA.debugLineNum = 125;BA.debugLine="label1.Initialize(\"\")";
Debug.ShouldStop(268435456);
_label1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 126;BA.debugLine="label2.Initialize(\"\")";
Debug.ShouldStop(536870912);
_label2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 127;BA.debugLine="label3.Initialize(\"\")";
Debug.ShouldStop(1073741824);
_label3.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 128;BA.debugLine="label4.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_label4.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 129;BA.debugLine="imgv.Initialize(\"\")";
Debug.ShouldStop(1);
_imgv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 130;BA.debugLine="iconlbl.Initialize(\"\")";
Debug.ShouldStop(2);
_iconlbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 134;BA.debugLine="Dim j As Int = panel0.Width * 0.9";
Debug.ShouldStop(32);
_j = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel0.runMethod(true,"getWidth"),RemoteObject.createImmutable(0.9)}, "*",0, 0));Debug.locals.put("j", _j);Debug.locals.put("j", _j);
 BA.debugLineNum = 135;BA.debugLine="Dim k As Int  = ( Activity.Height - 60) * 0.1";
Debug.ShouldStop(64);
_k = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),RemoteObject.createImmutable(60)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0));Debug.locals.put("k", _k);Debug.locals.put("k", _k);
 BA.debugLineNum = 138;BA.debugLine="label1.Text  = test";
Debug.ShouldStop(512);
_label1.runMethod(true,"setText",BA.ObjectToCharSequence(_test));
 BA.debugLineNum = 139;BA.debugLine="label1.Text.ToUpperCase";
Debug.ShouldStop(1024);
_label1.runMethod(true,"getText").runVoidMethod ("toUpperCase");
 BA.debugLineNum = 140;BA.debugLine="label1.TextSize = 22";
Debug.ShouldStop(2048);
_label1.runMethod(true,"setTextSize",BA.numberCast(float.class, 22));
 BA.debugLineNum = 141;BA.debugLine="label1.TextColor = Colors.Black";
Debug.ShouldStop(4096);
_label1.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 142;BA.debugLine="label1.Typeface = Typeface.LoadFromAssets(\"kr1.tt";
Debug.ShouldStop(8192);
_label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("kr1.ttf"))));
 BA.debugLineNum = 143;BA.debugLine="label1.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(16384);
_label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 146;BA.debugLine="label1.Tag = 0";
Debug.ShouldStop(131072);
_label1.runMethod(false,"setTag",RemoteObject.createImmutable((0)));
 BA.debugLineNum = 148;BA.debugLine="label2.TextSize = 13";
Debug.ShouldStop(524288);
_label2.runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 149;BA.debugLine="label2.TextColor = Colors.Black";
Debug.ShouldStop(1048576);
_label2.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 150;BA.debugLine="label2.Tag = 1";
Debug.ShouldStop(2097152);
_label2.runMethod(false,"setTag",RemoteObject.createImmutable((1)));
 BA.debugLineNum = 151;BA.debugLine="label2.Text = xtext";
Debug.ShouldStop(4194304);
_label2.runMethod(true,"setText",BA.ObjectToCharSequence(_xtext));
 BA.debugLineNum = 155;BA.debugLine="label3.TextColor = Colors.Black";
Debug.ShouldStop(67108864);
_label3.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 156;BA.debugLine="label3.Typeface = Typeface.LoadFromAssets(\"violat";
Debug.ShouldStop(134217728);
_label3.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("violatio.ttf"))));
 BA.debugLineNum = 157;BA.debugLine="label3.Gravity = Gravity.LEFT";
Debug.ShouldStop(268435456);
_label3.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 158;BA.debugLine="label3.Gravity = Gravity.BOTTOM";
Debug.ShouldStop(536870912);
_label3.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"BOTTOM"));
 BA.debugLineNum = 159;BA.debugLine="label3.TextSize = 14";
Debug.ShouldStop(1073741824);
_label3.runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 160;BA.debugLine="label3.Tag = 2";
Debug.ShouldStop(-2147483648);
_label3.runMethod(false,"setTag",RemoteObject.createImmutable((2)));
 BA.debugLineNum = 161;BA.debugLine="label3.Text = ytext";
Debug.ShouldStop(1);
_label3.runMethod(true,"setText",BA.ObjectToCharSequence(_ytext));
 BA.debugLineNum = 164;BA.debugLine="label4.TextColor = Colors.Black";
Debug.ShouldStop(8);
_label4.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 165;BA.debugLine="label4.Gravity = Gravity.LEFT";
Debug.ShouldStop(16);
_label4.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 166;BA.debugLine="label4.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(32);
_label4.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 167;BA.debugLine="label4.TextSize = 11";
Debug.ShouldStop(64);
_label4.runMethod(true,"setTextSize",BA.numberCast(float.class, 11));
 BA.debugLineNum = 168;BA.debugLine="label4.Tag = 3";
Debug.ShouldStop(128);
_label4.runMethod(false,"setTag",RemoteObject.createImmutable((3)));
 BA.debugLineNum = 169;BA.debugLine="label4.Text = ztext";
Debug.ShouldStop(256);
_label4.runMethod(true,"setText",BA.ObjectToCharSequence(_ztext));
 BA.debugLineNum = 173;BA.debugLine="imgv.Bitmap = LoadBitmap(File.DirAssets,\"contacts";
Debug.ShouldStop(4096);
_imgv.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("contacts-50.png"))).getObject()));
 BA.debugLineNum = 174;BA.debugLine="imgv.Gravity = Gravity.FILL";
Debug.ShouldStop(8192);
_imgv.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 176;BA.debugLine="iconlbl.Text = Chr(0xE7FD)";
Debug.ShouldStop(32768);
_iconlbl.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xe7fd)))));
 BA.debugLineNum = 177;BA.debugLine="iconlbl.TextColor = Colors.Black";
Debug.ShouldStop(65536);
_iconlbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 178;BA.debugLine="iconlbl.TextSize = 20";
Debug.ShouldStop(131072);
_iconlbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 184;BA.debugLine="panel1.AddView(label1, j * 0.2, 0, j * 0.63, k *";
Debug.ShouldStop(8388608);
_panel1.runVoidMethod ("AddView",(Object)((_label1.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.2)}, "*",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.63)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.375)}, "*",0, 0))));
 BA.debugLineNum = 185;BA.debugLine="panel1.AddView(label2,	j * 0.2,k * 0.375, j * 0.6";
Debug.ShouldStop(16777216);
_panel1.runVoidMethod ("AddView",(Object)((_label2.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.2)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.375)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.63)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.625)}, "*",0, 0))));
 BA.debugLineNum = 186;BA.debugLine="panel1.AddView(label3, j * 0.83, k * 0.05, j * 0.";
Debug.ShouldStop(33554432);
_panel1.runVoidMethod ("AddView",(Object)((_label3.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.83)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.05)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.17)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.375)}, "*",0, 0))));
 BA.debugLineNum = 187;BA.debugLine="panel1.AddView(label4, j * 0.83, k * 0.43, j * 0.";
Debug.ShouldStop(67108864);
_panel1.runVoidMethod ("AddView",(Object)((_label4.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.83)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.43)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_j,RemoteObject.createImmutable(0.17)}, "*",0, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_k,RemoteObject.createImmutable(0.375)}, "*",0, 0))));
 BA.debugLineNum = 189;BA.debugLine="panel1.AddView(iconlbl, 0, 0, 0.2 * j, k)";
Debug.ShouldStop(268435456);
_panel1.runVoidMethod ("AddView",(Object)((_iconlbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(0.2),_j}, "*",0, 0))),(Object)(_k));
 BA.debugLineNum = 191;BA.debugLine="panel0.AddView(panel1,(panel0.Width - j)/2,panelt";
Debug.ShouldStop(1073741824);
_panel0.runVoidMethod ("AddView",(Object)((_panel1.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel0.runMethod(true,"getWidth"),_j}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(main._paneltop),(Object)(_j),(Object)(_k));
 BA.debugLineNum = 193;BA.debugLine="panel1.BringToFront";
Debug.ShouldStop(1);
_panel1.runVoidMethod ("BringToFront");
 BA.debugLineNum = 196;BA.debugLine="paneltop = paneltop + k + 5dip";
Debug.ShouldStop(8);
main._paneltop = RemoteObject.solve(new RemoteObject[] {main._paneltop,_k,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1);
 BA.debugLineNum = 198;BA.debugLine="panel0.Height = panel0.Height + (( Activity.Heigh";
Debug.ShouldStop(32);
_panel0.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel0.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),RemoteObject.createImmutable(60)}, "-",1, 1)),RemoteObject.createImmutable(0.1)}, "*",0, 0))}, "+",1, 0)));
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,209);
if (RapidSub.canDelegate("button1_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");
 BA.debugLineNum = 209;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="AddMsgPanel(ScrlvQueue,\"hello\",\"hell\",\"none\", \"12";
Debug.ShouldStop(131072);
_addmsgpanel(main.mostCurrent._scrlvqueue,BA.ObjectToString("hello"),BA.ObjectToString("hell"),BA.ObjectToString("none"),RemoteObject.createImmutable("12,3"));
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createdatabase() throws Exception{
try {
		Debug.PushSubsStack("CreateDataBase (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
if (RapidSub.canDelegate("createdatabase")) return b4a.example.main.remoteMe.runUserSub(false, "main","createdatabase");
RemoteObject _query = RemoteObject.createImmutable("");
 BA.debugLineNum = 84;BA.debugLine="Sub CreateDataBase";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Private Query As String";
Debug.ShouldStop(1048576);
_query = RemoteObject.createImmutable("");Debug.locals.put("Query", _query);
 BA.debugLineNum = 87;BA.debugLine="Query = \"CREATE TABLE queue (ID INTEGER PRIMARY K";
Debug.ShouldStop(4194304);
_query = BA.ObjectToString("CREATE TABLE queue (ID INTEGER PRIMARY KEY, Contact TEXT, Message TEXT, DateTime INTEGER, Status INTEGER)");Debug.locals.put("Query", _query);
 BA.debugLineNum = 88;BA.debugLine="Messaging.SQL1.ExecNonQuery(Query)";
Debug.ShouldStop(8388608);
main.mostCurrent._messaging._sql1.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getalltablabels(RemoteObject _tabstrip) throws Exception{
try {
		Debug.PushSubsStack("GetAllTabLabels (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,91);
if (RapidSub.canDelegate("getalltablabels")) return b4a.example.main.remoteMe.runUserSub(false, "main","getalltablabels", _tabstrip);
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _tc = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
Debug.locals.put("tabstrip", _tabstrip);
 BA.debugLineNum = 91;BA.debugLine="Public Sub GetAllTabLabels (tabstrip As TabStrip)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="Dim jo As JavaObject = tabstrip";
Debug.ShouldStop(134217728);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_tabstrip);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 93;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(268435456);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 94;BA.debugLine="r.Target = jo.GetField(\"tabStrip\")";
Debug.ShouldStop(536870912);
_r.setField ("Target",_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("tabStrip"))));
 BA.debugLineNum = 95;BA.debugLine="Dim tc As Panel = r.GetField(\"tabsContainer\")";
Debug.ShouldStop(1073741824);
_tc = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_tc.setObject(_r.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("tabsContainer"))));Debug.locals.put("tc", _tc);
 BA.debugLineNum = 96;BA.debugLine="Dim res As List";
Debug.ShouldStop(-2147483648);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 97;BA.debugLine="res.Initialize";
Debug.ShouldStop(1);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 98;BA.debugLine="For Each v As View In tc";
Debug.ShouldStop(2);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group7 = _tc;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_v.setObject(group7.runMethod(false,"Get",index7));
Debug.locals.put("v", _v);
 BA.debugLineNum = 99;BA.debugLine="If v Is Label Then res.Add(v)";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
_res.runVoidMethod ("Add",(Object)((_v.getObject())));};
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 101;BA.debugLine="Return res";
Debug.ShouldStop(16);
if (true) return _res;
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getlbels() throws Exception{
try {
		Debug.PushSubsStack("getlBELS (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,215);
if (RapidSub.canDelegate("getlbels")) return b4a.example.main.remoteMe.runUserSub(false, "main","getlbels");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
 BA.debugLineNum = 215;BA.debugLine="Sub getlBELS As Int";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 217;BA.debugLine="For Each v As View In	ScrlvQueue.Panel.GetAllVie";
Debug.ShouldStop(16777216);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group1 = main.mostCurrent._scrlvqueue.runMethod(false,"getPanel").runMethod(false,"GetAllViewsRecursive");
final int groupLen1 = group1.runMethod(true,"getSize").<Integer>get()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_v.setObject(group1.runMethod(false,"Get",index1));
Debug.locals.put("v", _v);
 BA.debugLineNum = 218;BA.debugLine="If v Is Label Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 219;BA.debugLine="count = count + 1";
Debug.ShouldStop(67108864);
main._count = RemoteObject.solve(new RemoteObject[] {main._count,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 222;BA.debugLine="Return count";
Debug.ShouldStop(536870912);
if (true) return main._count;
 BA.debugLineNum = 223;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private PnlSplash As Panel";
main.mostCurrent._pnlsplash = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private PnlHome As Panel";
main.mostCurrent._pnlhome = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private ScrlvSent As ScrollView";
main.mostCurrent._scrlvsent = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private ScrlvQueue As ScrollView";
main.mostCurrent._scrlvqueue = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private TabStrip1 As TabStrip";
main.mostCurrent._tabstrip1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabStripViewPager");
 //BA.debugLineNum = 30;BA.debugLine="Dim paneltop As Int";
main._paneltop = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 32;BA.debugLine="Dim PanelHeight  = 45dip";
main.mostCurrent._panelheight = BA.NumberToString(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45))));
 //BA.debugLineNum = 34;BA.debugLine="Dim count As Int = 1";
main._count = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _imageview1_click() throws Exception{
try {
		Debug.PushSubsStack("ImageView1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,205);
if (RapidSub.canDelegate("imageview1_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","imageview1_click");
 BA.debugLineNum = 205;BA.debugLine="Sub ImageView1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="StartActivity(Add)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._add.getObject())));
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
messaging_subs_0._process_globals();
add_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
messaging.myClass = BA.getDeviceClass ("b4a.example.messaging");
add.myClass = BA.getDeviceClass ("b4a.example.add");
searchview.myClass = BA.getDeviceClass ("b4a.example.searchview");
mm.myClass = BA.getDeviceClass ("b4a.example.mm");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim timer1 As Timer";
main._timer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _querydbque(RemoteObject _scv) throws Exception{
try {
		Debug.PushSubsStack("QueryDbQue (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
if (RapidSub.canDelegate("querydbque")) return b4a.example.main.remoteMe.runUserSub(false, "main","querydbque", _scv);
RemoteObject _query = RemoteObject.createImmutable("");
RemoteObject _curs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("scv", _scv);
 BA.debugLineNum = 104;BA.debugLine="Sub QueryDbQue(scv As ScrollView)";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="Dim query As String = \"SELECT * FROM queue WHERE";
Debug.ShouldStop(256);
_query = BA.ObjectToString("SELECT * FROM queue WHERE Status = 0");Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 106;BA.debugLine="Dim curs As Cursor = Messaging.SQL1.ExecQuery(que";
Debug.ShouldStop(512);
_curs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_curs.setObject(main.mostCurrent._messaging._sql1.runMethod(false,"ExecQuery",(Object)(_query)));Debug.locals.put("curs", _curs);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer1_tick() throws Exception{
try {
		Debug.PushSubsStack("Timer1_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("timer1_tick")) return b4a.example.main.remoteMe.runUserSub(false, "main","timer1_tick");
 BA.debugLineNum = 79;BA.debugLine="Sub Timer1_Tick";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="timer1.Enabled = False";
Debug.ShouldStop(32768);
main._timer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 81;BA.debugLine="PnlSplash.SetVisibleAnimated(4000,False)";
Debug.ShouldStop(65536);
main.mostCurrent._pnlsplash.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 4000)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 82;BA.debugLine="End Sub";
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