[void][System.Reflection.Assembly]::LoadWithPartialName("System.Drawing") 
[void][System.Reflection.Assembly]::LoadWithPartialName("System.Windows.Forms") 
add-type -AssemblyName microsoft.VisualBasic
add-type -AssemblyName System.Windows.Forms

$signature=@'
[DllImport("user32.dll",CharSet=CharSet.Auto,CallingConvention=CallingConvention.StdCall)]
public static extern void mouse_event(long dwFlags, long dx, long dy, long cButtons, long dwExtraInfo);
'@

$SendMouseClick = Add-Type -memberDefinition $signature -name "Win32MouseEventNew" -namespace Win32Functions -passThru

$a = @(1..100)

while (1) {


    # Simulate a mouse click with a probability of 1 in 3 every 5 seconds
    $randomNumber = Get-Random -Minimum 1 -Maximum 2
    if ($randomNumber -eq 1) {
	[System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point(($a | Get-Random), ($a | Get-Random))
        
    }
	$SendMouseClick::mouse_event(0x00000002, 0, 0, 0, 0);
	$SendMouseClick::mouse_event(0x00000004, 0, 0, 0, 0);

    Start-Sleep -Seconds 5
}