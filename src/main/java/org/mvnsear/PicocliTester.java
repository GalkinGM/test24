package org.mvnsear;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(
        name = "Hello",
        description = "Описание команды тут",
        mixinStandardHelpOptions = true)


//@CommandLine.Command(name = "heLL", mixinStandardHelpOptions = true, version = "hello 4.0",
//        description = "Print hello to STDOUT.")

public class PicocliTester implements Callable<Integer> {

    @CommandLine.Parameters(index = "0",
            description = "the name to welcome.")
    private String names ;

//    @CommandLine.Option(names = {"-n", "--name"}, description = "Locale, such as en, zh ..")
//    private String name = "SSSSS";

    @CommandLine.Option(names = {"-u", "--user"}, required = true, description = "The user name.")
    private String name = "SSSSS";

    @CommandLine.Option(names = {"-n", "--nickName"}, required = true, description = "The user name.")
    private String nick = "SSSSS";

    @Override
    public Integer call() throws Exception {

        System.out.println("Hello, " + name +" " + nick);

        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new PicocliTester()).execute(args);
        System.exit(exitCode);
    }

}
