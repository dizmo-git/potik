package com.potik.Singletons;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends BaseSingleton<FileLogger>
{
    private final Path logDir;
    private final Path sessionLogFile;

    public FileLogger()
    {
        super();
        this.logDir = getLogDirectory();
        this.sessionLogFile = logDir.resolve(getSessionLogFileName());
        ensureLogFileExists();
    }

    private String getSessionLogFileName()
    {
        String dateAndTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return "session-log-" + dateAndTime + ".txt";
    }

    private Path getLogDirectory()
    {
        String localAppData = System.getenv("LOCALAPPDATA");
        if (localAppData == null)
        {
            // Non windows systems
            localAppData = System.getProperty("user.home") + File.separator + ".potik";
        }
        Path logDir = Paths.get(localAppData, "Potik", "Logs");
        try
        {
            Files.createDirectories(logDir);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not create log directory: " + logDir, e);
        }
        return logDir;
    }

    private void ensureLogFileExists()
    {
        try
        {
            if (!Files.exists(sessionLogFile))
            {
                Files.createFile(sessionLogFile);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not create log file: " + sessionLogFile, e);
        }
    }

    public void sessionLog(String message)
    {
        try
        {
            String line = "[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + message + System.lineSeparator();
            Files.writeString(sessionLogFile, line, StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not write to log file: " + sessionLogFile, e);
        }
    }

    public void logInFile(String message, String fileName)
    {
        fileName = fileName + ".txt";
        Path file = logDir.resolve(fileName);
        try
        {
            Files.writeString(file, message + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not write to custom log file: " + file, e);
        }
    }
}
