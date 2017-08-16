package com.jpanda.telegram.telegacity;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author Alexey Storozhev
 */
public class Main {
    public static void main(String[] args) {
        ConfigProperties.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TeamCity());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
