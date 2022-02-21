import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private ConnectFour cFour = new ConnectFour(true);

    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createLight("token", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new Bot())
                .setActivity(Activity.competing("creation competition concerning" +
                        " carefully conserving contemporary connect 4 confederation collectables"))
                .build();


    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String player;
        if (cFour.isRed()) {
            player = "red";
        } else {
            player = "blue";
        }
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!help")) {
            event.getChannel().sendMessage("!reset- rest board \n" +
                    "!board - display board \n" +
                    "!play *col* - play the col specified (1-7)")
                    .queue();
        }
        if (msg.getContentRaw().equals("!reset")) {
            cFour = new ConnectFour(true);
        }
        if (msg.getContentRaw().equals("!board")) {
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 1")) {
            cFour.play(1);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 2")) {
            cFour.play(2);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 3")) {
            cFour.play(3);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 4")) {
            cFour.play(4);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 5")) {
            cFour.play(5);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 6")) {
            cFour.play(6);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 7")) {
            cFour.play(7);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }
        }
    }

}
