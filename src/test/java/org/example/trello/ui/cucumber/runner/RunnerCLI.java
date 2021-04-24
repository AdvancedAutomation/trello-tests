package org.example.trello.ui.cucumber.runner;

import io.cucumber.core.cli.Main;

public final class RunnerCLI {

    private RunnerCLI() {
    }

    public static void main(final String[] args) {
        String[] params = new String[]{
                "--threads", "5",
                "--glue", "org.example",
                "-p", "pretty",
                "-t", "@bvt",
                "src/test/resources/features/"
        };
        Main.run(params, Thread.currentThread().getContextClassLoader());
    }

}
