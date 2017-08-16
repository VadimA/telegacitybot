package com.jpanda.telegram.telegacity;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * @author Alexey Storozhev
 */
public class TeamCity extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return ConfigProperties.getProperty("BOT.USERNAME");
    }

    public String getBotToken() {
        return ConfigProperties.getProperty("BOT.TOKEN");
    }
}
