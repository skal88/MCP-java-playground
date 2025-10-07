package com.albertmula.MCP.playground.tools;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class CopyToClipboardText {

    public String copy(String text){
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                copyForWindows(text);
            } else if (os.contains("mac")) {
                copyForMac(text);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                copyForLinux(text);
            }
            else {
                return "Unsupported operating system";
            }

            return "Successfully copied text!";
        } catch (RuntimeException e) {
            return "Error on copy Text";
        }
    }

    private void copyForLinux(String text) {
        try {
            // xclip is a Linux command to copy to the clipboard
            Process process = new ProcessBuilder("xclip", "-selection", "clipboard").start();

            // We write the text to the standard input of the process
            try (OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream())) {
                writer.write(text);
            }

            // We wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Text copied using the native xclip command.");
            } else {
                System.err.println("Error executing xclip, exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void copyForWindows(String text) {
        try {
            // clip is the Windows command to copy to the clipboard
            Process process = new ProcessBuilder("cmd", "/c", "echo " + text + " | clip").start();

            // We wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Text copied using the native clip command.");
            } else {
                System.err.println("Error executing clip, exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void copyForMac(String text){
        try {
            // pbcopy is the macOS command to copy to the clipboard
            Process process = new ProcessBuilder("pbcopy").start();

            // We write the text to the standard input of the process
            try (OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream())) {
                writer.write(text);
            }

            // We wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Text copied using the native pbcopy command.");
            } else {
                System.err.println("Error executing pbcopy, exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
