Type=Activity
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim alarmtime, alarmdate As Long
	Dim boolDate As Boolean = False
	Dim boolTime As Boolean = False
	
	Private LblDate As Label
	Private LblTime As Label
	Private TxtContacts As EditText
	
	Private LstContacts As ListView
	Private PnlContact As Panel
	Dim cu As ContactsUtils
	Dim selected As Boolean
	Dim Clist As List
	Private panSend As Panel
	Private EditText2 As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("2")
	cu.Initialize
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub LblTime_Click
	Dim alarmHours, alarmMinutes As Int
		
	Dim td As TimeDialog
	td.Hour = alarmHours
	td.Minute = alarmMinutes
	If td.Show("Select time to send message", "", "Ok", "Cancel", "", Null) = DialogResponse.POSITIVE Then
		alarmHours = td.Hour
		alarmMinutes = td.Minute
		
		alarmtime =  td.Hour * DateTime.TicksPerHour + td.Minute * DateTime.TicksPerMinute
		DateTime.TimeFormat = "HH:mm"
		LblTime.Text = DateTime.Time(alarmtime)
			
		boolTime = True
	End If
End Sub

Sub LblDate_Click
	Dim dd As DateDialog
	
	If dd.Show("Select date to send message", "", "Ok", "Cancel", "", Null) = DialogResponse.POSITIVE Then
		alarmdate = dd.DateTicks
		DateTime.DateFormat = "dd/MM/yyyy"
		LblDate.Text = DateTime.Date(alarmdate)
		boolDate = True
	End If
End Sub

Sub TxtContacts_TextChanged (Old As String, New As String)
	If New.Trim.Length > 0 Then
	
		PnlContact.Visible = True
		LstContacts.Clear

		Dim cu As ContactsUtils
		cu.Initialize
		Clist = cu.FindContactsByName(New,False, True)
		
		For i = 0 To Clist.Size - 1
			Dim c As cuContact = Clist.Get(i)
			For Each p As cuPhone In cu.GetPhones(c.Id)
				LstContacts.AddTwoLines2(c.DisplayName,p.Number,p.Number)
			Next
		Next
	Else
		PnlContact.Visible= False
	End If
End Sub

Sub LstContacts_ItemClick (Position As Int, Value As Object)
	TxtContacts.Text = Value
	PnlContact.Visible = False
End Sub


Sub ImageView4_Click

 	If TxtContacts.Text.Trim.Length = 0 Then
 		ToastMessageShow("please enter contact number", True)
		Return
	End If

	If boolDate = False Or boolTime = False Then
		ToastMessageShow("Enter date and time",True)
		Return
	End If
	
	If EditText2.Text.Trim.Length = 1 Then
		ToastMessageShow("Your sms is empty",True)
		Return
	End If
	
	Dim smsDatetime As Long = alarmdate + alarmtime
	
	If smsDatetime < DateTime.Now Then 
		ToastMessageShow("This time is past",True)
	Else
		AddMsg(EditText2.Text, smsDatetime, TxtContacts.Text)
	End If
	
End Sub


Sub AddMsg(sms As String,daytime As Long , phoneno As String)
	Dim query As String
	Dim curs As Cursor
	Dim status As Int = 1
	
	query = "SELECT * FROM queue WHERE sms = ? AND phoneno = ?"
	curs = Messaging.SQL1.ExecQuery2(query, Array As String (sms, phoneno))
	
	If curs.RowCount > 0 Then
		If Msgbox2("This sms to the same person already exist in the queue. Do you still want to send?", "", "Yes", "", "No", Null) = DialogResponse.POSITIVE Then
			query = "INSERT INTO queue VALUES (NULL, '" & phoneno & "', '" & sms & "', '" & daytime & "', '" & status & "')"
			Messaging.SQL1.ExecNonQuery(query)
			ToastMessageShow("SMS added to QUEUE", True)
		Else
			Return
		End If	
	Else
		query = "INSERT INTO queue VALUES (NULL, '" & phoneno & "', '" & sms & "', '" & daytime & "', '" & status & "')"
		Messaging.SQL1.ExecNonQuery(query)		
		ToastMessageShow("SMS added to QUEUE", True)
	End If
	
	curs.Close
	
End Sub

Sub reschedule
	Dim map As Map
	map.Initialize
	map = sqlGetClosest
	
	Dim alarm As Long = map.Get("Date")
	
	Log(alarm)
	
	If alarm < DateTime.Now Then alarm = DateTime.Add(alarm, 0, 0, 1)
	
	Log(DateTime.Date(alarm) & " " & DateTime.Time(alarm)) 'check the logs to see the set date and time
	'Calculate time to alarm
	Dim d, h, m As Int
	
	d = Floor((alarm - DateTime.Now) / DateTime.TicksPerDay)
	h = Floor((alarm - DateTime.Add(DateTime.Now, 0, 0, d)) / DateTime.TicksPerHour)
	m = ((alarm - DateTime.Now) - h * DateTime.TicksPerHour) / DateTime.TicksPerMinute
	
	ToastMessageShow("SMS will be sent after: " & NumberFormat(d, 2, 0) & " day(s) and "  & NumberFormat(h, 2, 0) & " hour(s) and " & NumberFormat(m, 2, 0) & " minute(s)", True)
	StartServiceAt(Messaging, alarm, True)
End Sub


Sub sqlGetClosest As Map
	Dim map As Map
	Dim cursor As Cursor
	
	map.Initialize
	
	cursor = Messaging.SQL1.ExecQuery("SELECT * FROM queue WHERE Status = 1 ORDER BY DateTime ASC")

	If cursor.RowCount > 0 Then
		cursor.Position = 0
		
		map.Put("id", cursor.GetInt("ID"))
		map.Put("Contact", cursor.GetString("Contact"))
		map.Put("Message", cursor.GetString("Message"))
		map.Put("Date", cursor.GetString("DateTime"))
		
	End If
	
	Log("map is " & CRLF & map)
	cursor.Close
	Return map
End Sub