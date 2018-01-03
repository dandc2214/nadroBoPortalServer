@ECHO OFF
SETLOCAL
SET PATH= "%%PATH%%;C:\Program Files (x86)\SAP BusinessObjects\SAP BusinessObjects Enterprise XI 4.0\win32_x86;C:\Program Files (x86)\SAP BusinessObjects\SAP BusinessObjects Enterprise XI 4.0\java\lib\PeopleSoft"
"C:\Program Files (x86)\SAP BusinessObjects\SAP BusinessObjects Enterprise XI 4.0\win32_x86\jdk\bin\java.exe" -jar "C:\Program Files (x86)\SAP BusinessObjects\SAP BusinessObjects Enterprise XI 4.0\java\lib\PeopleSoft\crpsepmsecuritybridge.jar" %1
