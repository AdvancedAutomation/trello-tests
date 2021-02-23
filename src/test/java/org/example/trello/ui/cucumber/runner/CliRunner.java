package org.example.trello.ui.cucumber.runner;

import io.cucumber.core.cli.Main;

public class CliRunner {
    public static void main(String[] args){
        String[] params = new String[]{
                "--threads","3",
                "--glue","org.example",
                "src/test/resources/features/",
                "-p","pretty"
        };
        Main.run(params, Thread.currentThread().getContextClassLoader());
    }
}
