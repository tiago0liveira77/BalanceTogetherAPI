@echo off

set BACKUP_DIR=backups
set TIMESTAMP=%date:~6,4%%date:~3,2%%date:~0,2%_%time:~0,2%%time:~3,2%%time:~6,2%
set TIMESTAMP=%TIMESTAMP: =0%
set FILE=%BACKUP_DIR%\balancetogether_%TIMESTAMP%.sql

if not exist "%BACKUP_DIR%" mkdir "%BACKUP_DIR%"

docker compose exec -T db mariadb-dump -u root -p123qwe balancetogether > "%FILE%"

echo Backup guardado em: %FILE%
