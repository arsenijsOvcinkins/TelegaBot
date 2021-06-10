import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
//import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Contact;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

//import java.awt.*;
//import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.IOException;

import java.util.*;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@MIF2020_TELEG_BOT";
        //возвращаем юзера
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("/help"));
        keyboardFirstRow.add(new KeyboardButton("/lecture1"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("/next"));
        keyboardSecondRow.add(new KeyboardButton("/чгк"));
        keyboardFirstRow.add(new KeyboardButton("/lecture2"));

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton("/game"));
        keyboardThirdRow.add(new KeyboardButton("/team"));


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    @SuppressWarnings("deprecation")
    public void SendMsg(Message msg, String txt) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        //System.out.println(msg.getChatId());
        setButtons(s);
        s.setText(txt);
        s.getReplyToMessageId();
        try {
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update e) {
        
        // Тут будет то, что выполняется при получении сообщения
        Message msg = e.getMessage(); // Это нам понадобится
        String txt = msg.getText();
        String name = e.getMessage().getFrom().getFirstName();

//        String stickerId = "CAACAgQAAxkBAAEBMxJfNoBdfkW6JvH4jCrAGgR2iTZmCQACHAAD0Xi1Ew-QYbAYCncTGgQ";
//            SendSticker sendSticker = new SendSticker();
//            if (txt.startsWith("/sticker")){
//                SendMsg(msg, sendSticker.setSticker(stickerId));
//            }

        String ans1 = "\nОтвет: Грязные лапы.\n" +
                "Зачёт: Грязные ноги.";
        String ans2 = "\nСоздатель машины времени\n" +
                "Зачёт: Создатель <<Машины времени>>\n" +
                "Комментарий: Один из создателей группы <<Машина времени>> Сергей Кавагое учился в 20-й московской школе в 1960-1970 годах. Ученик этой же школы Николай Садовский, если верить предсказанию Алисы в фильме <<Гостья из будущего>>, создаст в XXI веке машину времени.";
        String ans3 = "\nСухой закон.\n" +
                "Комментарий: Коктейль, по одной из версий, был изобретен в годы Сухого закона.";
        String ans4 = "\nКлассики";
        String ans6 = "\nОтвет: Рисовать.\n"+
                "Комментарий: Тони Старк — изобретатель, как и Леонардо, но не художник. В 1963 году вышел первый выпуск комиксов о Железном человеке.";
        String ans5 = "\nОтвет: Искупить вину кровью.\n" +
                "Зачёт: Смыть вину кровью.\n"+
                "Комментарий: Китайская компания Moliyo [молИйо] предложила попавшим в бан в игре Cabal Online [кэйбл онлАйн] стать донорами крови в обмен на разбан. Желающие стать донором должны удовлетворять некоторым требованиям по здоровью.";

        if (txt.startsWith("/чгк")){
            Random rand = new Random();
            int n = rand.nextInt(6)+1;
            switch (n){
                case 1:
                    SendMsg(msg,"# "+ n +" Когда собака возвращается домой с НИМИ, хозяева обычно не рады. Герой одного из мифов Междуречья, напротив, очень обрадовался, когда птицы вернулись с НИМИ. Назовите ИХ двумя словами.\n" +
                            "/ans1 чтобы посмотреть ответ");
                    break;
                case 2:
                    SendMsg(msg,"# "+ n +" Герой фильма <<Гостья из будущего>>, ставший ИКСОМ, учился в той же школе, в которой учился реальный человек, ставший одним из ИГРЕКОВ. ИКС и ИГРЕК на слух неотличимы. Назовите ИКСА или ИГРЕКА тремя словами.\n" +
                            "/ans2 чтобы посмотреть ответ");
                    break;
                case 3:
                    SendMsg(msg,"# "+ n +" Коктейль <<Лонг-Айленд>> внешне и ароматом напоминает холодный чай. В пояснении причины этого упоминается ИКС. Какие два слова мы заменили на ИКС?\n" +
                            "/ans3 чтобы посмотреть ответ");
                    break;
                case 4:
                    SendMsg(msg,"# "+ n +" Однажды, заметив играющих детей, Владимир Маяковский попробовал принять участие в их игре. Когда писателя на этом поймали серьезные люди, он смутился и спросил: \"Ну что, гожусь я в ИКСЫ?\". Какое слово мы заменили на ИКСЫ?\n" +
                            "/ans4 чтобы посмотреть ответ");
                    break;
                case 5:
                    SendMsg(msg,"# "+ n +"Игрокам, забаненным за какие-либо проступки в одной онлайн RPG, служба поддержки предоставила возможность в прямом смысле СДЕЛАТЬ ЭТО и вернуться в игру. Этим могли воспользоваться далеко не все игроки. Какие три слова мы заменили словами СДЕЛАТЬ ЭТО?\n" +
                            "/ans5 чтобы посмотреть ответ");
                    break;
                case 6:
                    SendMsg(msg,"# "+ n +" Когда Тони Старка называют Леонардо да Винчи нашего времени, тот отвечает, что это полная чепуха, ведь он не ДЕЛАЕТ ЭТО. Со Старком впервые СДЕЛАЛИ ЭТО в 1963 году. Что такое ДЕЛАТЬ ЭТО?\n" +
                            "/ans6 чтобы посмотреть ответ");
                    break;
            }
        }

        if (txt.startsWith("/ans1")) {
            SendMsg(msg,ans1);
        }
        if (txt.startsWith("/ans2")) {
            SendMsg(msg,ans2);
        }
        if (txt.startsWith("/ans3")) {
            SendMsg(msg,ans3);
        }
        if (txt.startsWith("/ans4")) {
            SendMsg(msg,ans4);
        }
        if (txt.startsWith("/ans5")) {
            SendMsg(msg,ans5);
        }
        if (txt.startsWith("/ans6")) {
            SendMsg(msg,ans6);
        }


        if (txt.startsWith("/help")) {
            SendMsg(msg,"/lecture1 Информация о первой лекции\n" +
                            "/lecture2 Информация о второй\n" +
                            "/next Следующий event расписания\n" +
                            "/game Информация о вечернем мероприятии\n" +
                            "/team Команды на вечернюю игру\n" +
                            "\nЧтобы написать автору бота, введите /feedback + текст сообщения");
        }
        if (txt.startsWith("/start")) {
            SendMsg(msg, "Будь как дома " + name +",\n" +
                    "я ни в чём не откажу");
        }

        if (txt.startsWith("/rude")) {
            String url = "https://memepedia.ru/wp-content/uploads/2020/02/beda-s-bashkoj-8.jpg";
            SendMsg(msg, url);
        }

        if (txt.startsWith("/feedback")) {
            String tStr = txt;
            tStr = tStr.replaceFirst("(?i)"+"/feedback", "");
            SendMessage s = new SendMessage();
            s.setChatId("462071152");
            s.setText(tStr +" "+ name);
            System.out.println(tStr + " @" +name);
            String thanks = "Спасибо за Ваш отзыв!";

            SendMsg(msg, thanks);

        }
        String lecture1 = "\n>>>>>>>>>>>>>Juniors<<<<<<<<<<<<<<\n" +
                "15:00 – 16:20. \nРябова М.О. \nСмайлики из атомов.\n" +
                "Кабинет №40" +
                "\n>>>>>>>>>>>>>Seniors<<<<<<<<<<<<<<\n" +
                "15:00 – 16:20. \n" + "Шехурина Э.Ю. \nВещества, влияющие на нервную систему \nКабинет №41";
        if (txt.startsWith("/lecture1")) {
            SendMsg(msg,lecture1);
        }

        String lecture2 = "\n>>>>>>>>>>>>>Juniors<<<<<<<<<<<<<<\n" +
                "16:40 – 18:00." +
                "\nЕфимова В.Г. \nО системах счисления. Часть 2.\n" +
                "Кабинет №45" +
                "\n>>>>>>>>>>>>>Seniors<<<<<<<<<<<<<<\n" +
                "16:40 – 18:00.\n" +
                "Бардин Н.В. \nGaudeamus igitur\n" +
                "Кабинет 41";

        if (txt.startsWith("/lecture2")) {
            SendMsg(msg,lecture2);
        }
        String game = "20:00 - 22:59\n" +
                "Брейн";
        if (txt.startsWith("/game")) {
            SendMsg(msg, game);
        }


        if (txt.startsWith("/team")) {
            String team = null;
            try {
                team = Reader.teams();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            SendMsg(msg, team);
        }

        if(txt.startsWith("/sticker")){
            SendMsg(msg,"CAACAgQAAxkBAAEBMxJfNoBdfkW6JvH4jCrAGgR2iTZmCQACHAAD0Xi1Ew-QYbAYCncTGgQ");
        }
        if (txt.startsWith("/next")) {
            Calendar now = Calendar.getInstance();
            String time = new String();
            float HourInt = Integer.parseInt(String.valueOf(now.get(Calendar.HOUR_OF_DAY)));
            float MinInt = Integer.parseInt(String.valueOf(now.get(Calendar.MINUTE)));

            //System.out.println(HourInt);
            //System.out.println(MinInt/100);
            float timeFloat = HourInt + MinInt / 100;
            System.out.println(timeFloat);
            //int timeInt = (int) (HourInt * 60 + MinInt);
            //System.out.println(timeInt);
            if (timeFloat > 8.01 && timeFloat <= 8.20) {
                SendMsg(msg, "Завтрак с 8:20 до 9:00");
            }
            if (timeFloat > 0.01 && timeFloat <= 9.00) {
                SendMsg(msg, "Завтрак\n" +
                        "С 9:00 до 13:00 - выбранный вами проект");
            }
            if (timeFloat > 9.01 && timeFloat <= 13.00) {
                SendMsg(msg, "Интеллектуальный труд\n" +
                        "Далее обед с 13 до 14");
            }
            if (timeFloat > 13.01 && timeFloat <= 15.00) {
                SendMsg(msg, lecture1);
            }
            if (timeFloat > 15.01 && timeFloat <= 16.20) {
                SendMsg(msg, "Полдник с 16:20 до 16:40");
            }
            if (timeFloat > 16.21 && timeFloat <= 16.40) {
                SendMsg(msg, lecture2);
            }
            if (timeFloat > 16.41 && timeFloat <= 19.00) {
                SendMsg(msg, "Ужин с 19:00");
            }
            if (timeFloat > 19.01 && timeFloat <= 20.00) {
                SendMsg(msg, game);
            }
        }
    }
        private void SendMsg ( int i){
        }

        @Override
        public String getBotToken () {
            return "1377025737:AAHoBd8SGPnGCxNq_OvG3iTcZEgzUmf0EQs";
            //Токен бота
        }
    }