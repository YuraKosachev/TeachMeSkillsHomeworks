package Game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GallowGame {
    // Reset
    private static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    private static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String WHITE = "\033[0;37m";   // WHITE

    private static final int ATTEPMPTS = 8;

    private static String[] lang = {"eng", "rus"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            start(scanner);

            String answer = input("Enter \"e\" to exit or other to continue.. :", BLUE, scanner);

            if (Character.toLowerCase(answer.charAt(0)) == 'e' || Character.toLowerCase(answer.charAt(0)) == 'е')
                break;
        }

    }

    private static boolean chooseEng(Scanner scanner) {
        StringBuilder builder = new StringBuilder();
        builder.append("Choose your language:\n");
        for (int i = 0; i < lang.length; i++) {
            builder.append("[" + i + "] - " + lang[i] + "\n");
        }
        builder.append("Your choice:");

        while (true) {
            print(builder.toString(), BLUE, false);
            if (!scanner.hasNextInt()) {
                print("Please enter number", RED, true);
                continue;
            }

            try {
                int index = scanner.nextInt();
                return lang[index].equals("eng");

            } catch (Exception ex) {
                print("Error : enter correct value", RED, true);
            }
        }
    }

    public static void start(Scanner scanner) {
        String name = input("Enter your name: ", PURPLE, scanner);
        boolean isEng = chooseEng(scanner);
        String word = getWord(isEng);

        if (word == null || word.isEmpty()) {
            print("Error: The game dictionary is not filled", RED, true);
            return;
        }

        char[] selectedLetter = createChoseenLetterArr(word);
        //set random letter


        boolean isGameWon = false;
        for (int attempt = 0; attempt < ATTEPMPTS; ) {
            drawGameProcess(scanner, name, attempt, word, selectedLetter, isEng);

            String choose = guessWord("Enter all word or letter: ", scanner, selectedLetter, isEng);

            if (choose.length() > 1) {
                //user entered the entire word
                isGameWon = word.toLowerCase().equals(choose.trim().toLowerCase());
                break;
            }
            char letter = choose.charAt(0);
            selectedLetter = extendArray(selectedLetter, letter);

            if (isAllLetterCover(word, selectedLetter)) {
                isGameWon = true;
                break;
            }

            if (!contain(word, letter)) {
                attempt++;
            }

        }
        drawGameResult(isGameWon, name, word);

    }

    private static boolean isAllLetterCover(String word, char[] selectedLetter) {
        for (char letter : word.toCharArray()) {
            if (!contain(selectedLetter, letter))
                return false;
        }
        return true;
    }

    private static char[] extendArray(char[] source, char letter) {
        char[] copyArray = Arrays.copyOf(source, source.length + 1);

        copyArray[source.length] = letter;
        return copyArray;
    }

    private static String guessWord(String message, Scanner scanner, char[] choosenLetter, boolean isEng) {
        while (true) {
            String choose = input(message, PURPLE, scanner);

            if (choose == null || choose.trim().isEmpty()) {
                print("Error: letter or word is incorrect", RED, true);
                continue;
            }

            boolean checkLang = isEng
                    ? containAllCyrillic(choose.toCharArray())
                    : !containAllCyrillic(choose.toCharArray());

            if (checkLang) {
                print("Error: Enter a " + (isEng ? "Latin" : "Cyrillic") + " word or letter", RED, true);
                continue;
            }
            if (choose.length() == 1 && contain(choosenLetter, choose.charAt(0))) {
                print("Error: you have already entered this letter", RED, true);
                continue;
            }

            return choose;
        }
    }

    private static boolean containAllCyrillic(char[] source) {
        for (int i = 0; i < source.length; i++) {
            if (!(Character.UnicodeBlock.of(source[i]).equals(Character.UnicodeBlock.CYRILLIC))) {
                return false;
            }
        }
        return true;
    }

    private static char[] createChoseenLetterArr(String word) {
        Random random = new Random();
        //set random letter from word to new array
        return new char[]{word.charAt(random.nextInt(0, word.length() - 1))};
    }

    private static void drawGameProcess(Scanner scanner, String player, int attempt, String word, char[] choosenLetter, boolean isEng) {
        print("Player name:" + player, CYAN, true);
        drawScence(attempt);

        print("Guess the word:", BLUE, true);
        drawWordPanel(word, choosenLetter);

        print("Selected letters", BLUE, true);
        drawAlphabet(choosenLetter, word, isEng);
    }

    private static void drawGameResult(boolean isWinner, String player, String word) {
        //clearConsole();
        if (!isWinner) {
            drawScence(8);
        }
        String phrase = isWinner
                ? GREEN + "Congratulations! " + player + " won game"
                : RED + player + " lose";
        print(phrase, null, true);
        print("Guess the word:", BLUE, true);
        drawWordPanel(word, word.toCharArray());
    }

    private static void drawScence(int attempt) {
        String scence = getScences(attempt);
        print(scence, BLUE, true);
    }

    private static String getScences(int attempt) {
        StringBuilder builder = new StringBuilder();
        switch (attempt) {
            case 0 -> builder
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n")
                    .append("\n");

            case 1 -> builder
                    .append("\n")
                    .append("    * \n")
                    .append("    * \n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("\n");

            case 2 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    * \n")
                    .append("    * \n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("\n");
            case 3 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  * \n")
                    .append("    * \n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");

            case 4 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  *                  * \n")
                    .append("    *                     *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");

            case 5 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  *                  * \n")
                    .append("    *                     *\n")
                    .append("    *                  .****.\n")
                    .append("    *                  |    |\n")
                    .append("    *                  '****'\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");

            case 6 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  *                  * \n")
                    .append("    *                     *\n")
                    .append("    *                  .****.\n")
                    .append("    *                  |    |\n")
                    .append("    *                  '****'\n")
                    .append("    *                 '*******'\n")
                    .append("    *                 |       |\n")
                    .append("    *                 |       |\n")
                    .append("    *                 |       |\n")
                    .append("    *                 '*******'\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");

            case 7 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  *                  * \n")
                    .append("    *                     *\n")
                    .append("    *                  .****.\n")
                    .append("    *                  |    |\n")
                    .append("    *                  '****'\n")
                    .append("    *               * '*******' *\n")
                    .append("    *              *  |       |  *\n")
                    .append("    *             *   |       |   *\n")
                    .append("    *                 |       |\n")
                    .append("    *                 '*******'\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");


            case 8 -> builder
                    .append("  * * * * * * * * * * * * * *\n")
                    .append("    *  *                  * \n")
                    .append("    *                     *\n")
                    .append("    *                  .****.\n")
                    .append("    *                  |    |\n")
                    .append("    *                  '****'\n")
                    .append("    *               * '*******' *\n")
                    .append("    *              *  |       |  *\n")
                    .append("    *             *   |       |   *\n")
                    .append("    *                 |       |\n")
                    .append("    *                 '*******'\n")
                    .append("    *                  |     | \n")
                    .append("    *                  |     |\n")
                    .append("    *                  |     |\n")
                    .append("    *\n")
                    .append("    *\n")
                    .append(" *******\n");
            default -> builder.append("Not that attempt");
        }
        return builder.toString();
    }

    private static String getWord(boolean isEng) {
        String[] ruWords = {
                "Барановичи",
                "Берёза",
                "Брест",
                "Гусак",
                "Давид-Городок",
                "Дрогичин",
                "Иваново",
                "Ивацевичи",
                "Каменец",
                "Кобрин",
                "Кошице",
                "Крыница",
                "Лунинец",
                "Микашевичи",
                "Пинск",
                "Пружаны",
                "Балаи",
                "Витебск",
                "Воропаево",
                "Глубокое",
                "Городок",
                "Дисна",
                "Дубки",
                "Каменец",
                "Королево",
                "Лепель",
                "Нова",
                "Ново",
                "Новолукомль",
                "Новополоцк",
                "Орша",
                "Полоцк",
                "Посад",
                "Поставы",
                "Советская",
                "Ушачи",
                "Ветка",
                "Гомель",
                "Добруш",
                "Житковичи",
                "Жлобин",
                "Калинковичи",
                "Марина",
                "Марино",
                "Медведев",
                "Медведь",
                "Мозырь",
                "Прогресс",
                "Речица",
                "Рогачев",
                "Степанов",
                "Стрешин",
                "Туров",
                "Хойники",
                "Волковыск",
                "Голынка",
                "Гродно",
                "Красносельский",
                "Лида",
                "Мосты",
                "Новогрудок",
                "Росс",
                "Скидель",
                "Слоним",
                "Сморгонь",
                "Щучин",
                "Минск",
                "Борисов",
                "Вилейка",
                "Воложин",
                "Выголовичи",
                "Гатово",
                "Гута",
                "Дзержинск",
                "Жодино",
                "Заславль",
                "Каменец",
                "Колодищи",
                "Лада",
                "Логойск",
                "Любань",
                "Малиновка",
                "Марьина",
                "Молодечно",
                "Несвиж",
                "Плещеницы",
                "Прогресс",
                "Рудня",
                "Слуцк",
                "Смолевичи",
                "Солигорск",
                "Столбцы",
                "Бобруйск",
                "Быхов",
                "Горки",
                "Климовичи",
                "Костюковичи",
                "Кричев",
                "Мишин",
                "Могилёв",
                "Осиповичи",
                "Сава",
                "Степанов",
                "Чериков",
                "Шклов",
        };

        String[] engWords = {
                "London",
                "Birmingham",
                "Leeds",
                "Glasgow",
                "Belfast",
                "Sheffield",
                "Manchester",
                "Bradford",
                "Edinburgh",
                "Liverpool",
                "Bristol",
                "Wakefield",
                "Cardiff",
                "Coventry",
                "Leicester",
                "Nottingham",
                "Sunderland",
                "Belfast",
                "Newcastle",
                "Plymouth",
                "Derby",
                "Wolverhampton",
                "Westminster",
                "Southampton",
                "Swansea",
                "Salford",
                "Portsmouth",
                "Northampton",
                "Dudley",
                "York",
                "Aberdeen",
                "Milton",
                "Luton",
                "Peterborough",
                "Walsall",
                "Bournemouth",
                "Telford",
                "Ripon",
                "Brighton",
                "Swindon",
                "Oxford",
                "Canterbury",
                "Huddersfield",
                "Reading",
                "Middlesbrough",
                "Blackpool",
                "Dundee",
                "Newport",
                "Bolton",
                "Pool",
                "Stockport",
                "Ipswich",
                "Norwich",
                "Preston",
                "Norwich",
                "Gloucester",
                "Exeter",
                "Cambridge",
                "Chester",
                "Slough",
                "Rotherham",
                "Winchester",
                "Blackburn",
                "Colchester",
                "Chesterfield",
                "Oldham",
                "Carlisle",
                "Crawley",
                "Durham",
                "Worcester",
                "Lincoln",
                "Bath",
                "Bangor",
                "Lisburn",
                "Newtownabbi",
                "Craigavon",
                "Inverness",
                "Hereford",
                "Edinburgh",
                "Llanelli",
                "Lancaster",
                "Nit",
                "Salisbury",
                "Perth",
                "Wrexham",
                "Sterling",
                "Port",
                "Aberdare",
                "Pontyprit",
                "Ballimine",
                "Newtownards",
                "Newry",
                "Carrickfergus",
                "Coleraine",
                "Chichester",
                "Lurgan",
                "Ohm",
                "Portadown",
                "Truro",
                "Llandudno",
                "Dundonald",
                "Antrim",
                "Larne",
                "Strabban",
                "Or",
                "Banbridge",
                "Armagh",
                "Abergavenny",
                "Conwy",
                "Enniskillen",
                "Bargoyd",
                "Carmarthen",
                "Aberystwyth",
                "Limavadi",
                "Holywood",
                "Caldicott",
                "Holyhead",
                "Dungannon",
                "Chepstow",
                "Haverfordwest",
                "Cookstown",
                "Abergele",
                "Wells",
                "Downpatrick",
                "Aberbrogoyd",
                "Brecon",
                "Paisley",
                "East",
                "Livingston",
                "Aberavon",
                "Cumbernauld",
                "Dunfermline",
                "Kirkcaldy",
                "Abercarn",
                "Ayr",
                "Kilmarnock",
                "Coatbridge",
                "Greenock",
                "Llangollen",
                "Edri",
                "Falkirk",
                "Amlouh",
                "Erwin",
                "Dumfries",
                "Motherwell",
                "Rutherglen",
                "Lichfield",
                "Wishaw",
                "Cabunes",
                "Bersden",
                "Clydebank",
                "Barmouth",
                "Arbroath",
                "Musselborough",
                "Bishopbriggs",
                "Benlech",
                "Ask",
                "Elgin",
                "Renfrew",
                "Bathgate",
                "Belshill",
                "Bomaris",
                "Alloa",
                "Dumbarton",
                "Kirkillilloch",
                "Peterhead",
                "Barrhead",
                "Grencjmut",
                "Blantyre",
                "Kiluining",
                "Johnston",
                "Bonnirigg",
                "Penik",
                "View",
                "Erskine",
                "Broxburn",
                "Aberrayron",
                "Port",
                "Larkhall",
                "Queensferry",
                "Llanvillin",
                "Hamilton",
                "Glenrothes",
                "Saint"
        };

        Random random = new Random();
        String[] wordDictionary = isEng ? engWords : ruWords;
        return wordDictionary[random.nextInt(0, wordDictionary.length - 1)];
    }

    private static void drawWordPanel(String word, char[] letters) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            if (contain(letters, word.charAt(i))) {
                builder.append(YELLOW + "[ " + word.charAt(i) + " ] " + RESET);
                continue;
            }

            builder.append(YELLOW + "[ * ] " + RESET);
        }
        print(builder.toString(), null, true);
    }

    private static void drawAlphabet(char[] selected, String word, boolean isEng) {
        final int ENG_START = 65;
        final int ENG_END = 90;
        final int RU_START = 1040;
        final int RU_END = 1071;
        final int ROW_LENGTH = 9;
        int start = isEng ? ENG_START : RU_START;
        int end = isEng ? ENG_END : RU_END;

        StringBuilder builder = new StringBuilder();
        for (int i = start, counter = 0; i <= end; i++, counter++) {

            if (counter == ROW_LENGTH) {
                builder.append("\n");
                counter = 0;
            }

            if (!contain(selected, (char) i)) {
                builder.append(WHITE + "[ " + ((char) i) + " ] " + RESET);
                continue;
            }

            builder.append((contain(word, (char) i) ? GREEN : RED) + "[ " + ((char) i) + " ] " + RESET);
        }
        print(builder.toString(), null, true);
    }

    private static boolean contain(String word, char letter) {
        return word.toLowerCase().indexOf(Character.toLowerCase(letter)) > -1;
    }

    private static boolean contain(char[] chars, char letter) {
        for (int i = 0; i < chars.length; i++) {
            if (Character.toLowerCase(chars[i]) == Character.toLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static String input(String message, String color, Scanner scanner) {
        print(message, color, false);
        return scanner.next();
    }

    private static void print(String message, String color, boolean isNextLine) {

        System.out.print((color == null ? "" : color) + message + RESET + (isNextLine ? "\n" : ""));
    }

}
