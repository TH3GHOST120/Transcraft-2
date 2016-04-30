@echo off
powershell Set-ExecutionPolicy Unrestricted -Scope CurrentUser
powershell ./SetUpLibs.ps1
echo Download of libraries completed.
PAUSE