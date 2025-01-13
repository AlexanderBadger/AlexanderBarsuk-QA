package Task_6;

public final class Constants {
    public static final String[] STRING_FOR_TASK = new String[]{
            "Менеджер, программист и тестировщик попали в ДТП,  несясь с горы,  из-за отказа тормозов",
            "Менеджер предложил сформировать группу обсуждения проблемы с тормозами",
            "Программист предложил проверить каждый винтик",
            "Тестировщик предложил затолкать машину в гору и повторить баг"
    };
    public static final String[] PALINDROME = new String[]{
            "Ежу хуже",
            "Лев осовел",
            "Кошмар, срам, шок",
            "Кирилл лирик"
    };
    public static final String[] OUR_NAMES = new String[]{
            "Бокова Марина Викторовна",
            "Бородина Ольга Викторовна",
            "Лазарева Анастасия Сергеевна",
            "Николаева Наталья Игоревна",
            "Приданников Николай Михайлович",
            "Барсук Александр Владимирович"
    };
    public static final String[] EMPTY_LINES = new String[]{
            "Ежу хуже",
            " ",
            "Кошмарсрамшок",
            "",
            "Кирилл лирик"
    };
    public static final String RUS_VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";

    public static final String RUS_CONSONANTS = "бвгджзйклмнпрстфхцчшщ";

    public static final String ALLOWED_SYMBOLS = "[^\\da-zA-Zа-яёА-ЯЁ]";

    public static final String SPACES = "\\s*,\\s*";

    public static final String ONLY_LETTERS = "[^a-zA-Zа-яА-Я]";

    public static final String SEPARATION = "\\s+|,\\s*";

    public static final String SPACE = " ";

    public static final String SHORT_NAME = "^\\s*([\\wА-Яа-я]+)"
            + "(\\s+([\\wА-Яа-я]?)\\S*)?(\\s+([\\wА-Яа-я]?)[\\wА-Яа-я]*.*)?";
}