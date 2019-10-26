@echo off
set DIR="%~dp0"
set JAVA_EXEC="%DIR:"=%\java"
pushd %DIR% & %JAVA_EXEC%  -m org.scenicview.scenicview/org.scenicview.ScenicView  %* & popd
