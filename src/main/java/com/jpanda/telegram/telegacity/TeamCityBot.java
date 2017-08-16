package com.jpanda.telegram.telegacity;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;


/**
 * @author Alexey Storozhev
 */
public class TeamCityBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
//            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
//                    .setChatId(update.getMessage().getChatId())
//                    .setText(update.getMessage().getText());
//            try {
//                sendMessage(message); // Call method to send the message
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
            if (update.hasMessage() && update.getMessage().hasText()) {
                String message_text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();
                if (update.getMessage().getText().equals("/start")) {


                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("You send " + message_text);
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
                    rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
                    rowInline.add(new InlineKeyboardButton().setText("Забить").setCallbackData("update_msg_text"));
                    rowInline.add(new InlineKeyboardButton().setText("Сплясать").setCallbackData("update_msg_text"));
                    List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                    rowInline2.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
                    rowInline2.add(new InlineKeyboardButton().setText("Забить").setCallbackData("update_msg_text"));
                    rowInline2.add(new InlineKeyboardButton().setText("Сплясать").setCallbackData("update_msg_text"));
                    // Set the keyboard to the markup
                    rowsInline.add(rowInline);
                    rowsInline.add(rowInline2);
                    // Add it to the message
                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    try {
                        sendMessage(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    SendMessage message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("You send " + message_text);
                    try {
                        sendMessage(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

            } else if (update.hasCallbackQuery()) {
                // Set variables
                String call_data = update.getCallbackQuery().getData();
                long message_id = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

                if (call_data.equals("update_msg_text")) {
                    String answer = "Updated message texti";
                    EditMessageText new_message = new EditMessageText()
                            .setChatId(chat_id)
                            .setMessageId(toIntExact(message_id))
                            .setText(answer);
                    try {
                        editMessageText(new_message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    public String getBotUsername() {
        return ConfigProperties.getProperty("BOT.USERNAME");
    }

    public String getBotToken() {
        return ConfigProperties.getProperty("BOT.TOKEN");
    }
}
