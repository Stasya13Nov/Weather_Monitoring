import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerName = new Scanner(System.in);

        Controller controller = new Controller();
        City city2 = new City();
        int choice = 0;
        String name;
        int idCountry, idCity;
        int info = 0;
        Thread threadW = new Thread(new RunnableWelcome());
        threadW.start();
        Thread.sleep(4000);

        do {
            System.out.println("Введите:\n1-создать страну\n2-создать город\n3-добавить город к стране\n4-вывести города без страны" +
                    "\n5-вывести все страны\n6-вывести города по индексу страны\n7-ввести всю информацию о погоде в городе\n8-вывести всю" +
                    " информацию о погоде в городе\n9-вывести самый теплый и холодный город и его температуру\n" +
                    "10-вывести город c максимальным и минимальным давлением и его значением\n11-вывести город c максимальной и минимальной влажностью и ее значением\n" +
                    "12-вывести город с максимальными и минимальными осадками\n13- вывести самый комфортный город для жизни\n0-выход");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("введите страну");
                    name = scannerName.nextLine();
                    controller.createCounry(name);
                    break;
                case 2:
                    System.out.println("введите город");
                    name = scannerName.nextLine();
                    controller.createCity(name);
                    break;
                case 3:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    System.out.println("Введите id города");
                    idCity = scanner.nextInt();
                    controller.addCityToCountryFromCitiesWithoutCoutry(idCountry, idCity);
                    break;
                case 4:
                    if (controller.citiesWithoutCoutry.isEmpty()){
                        System.out.println("Городов без страны нету");
                    }
                    else
                        for (City city : controller.citiesWithoutCoutry) {
                        System.out.println(city);
                    }
                    break;
                case 5:
                    for (Country country : controller.countries) {
                        System.out.println(country);
                    }
                    break;
                case 6:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    for (City city : controller.getCitiesFromCountry(idCountry)) {
                        System.out.println(city);
                    }
                    break;
                case 7:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    System.out.println("Введите id города");
                    idCity = scanner.nextInt();

                    System.out.println("Введите максимальную температуру за июль");
                    info = scanner2.nextInt();
                    controller.getCitiesFromCountry(idCountry).get(idCity).addMaxTemp(info);

                    System.out.println("Введите минимальную температуру за июль");
                    info = scanner2.nextInt();
                    controller.getCitiesFromCountry(idCountry).get(idCity).addMinTemp(info);

                    System.out.println("Введите среднее значение атмосферного давления за июль");
                    info = scanner2.nextInt();
                    controller.getCitiesFromCountry(idCountry).get(idCity).addPressure(info);

                    System.out.println("Введите среднее значение влажности за июль");
                    info = scanner2.nextInt();
                    controller.getCitiesFromCountry(idCountry).get(idCity).addHumidity(info);

                    System.out.println("Введите информацию об осадках в июле. Введите 1-мало, 2-средне, 3-много");
                    info = scanner2.nextInt();
                    controller.getCitiesFromCountry(idCountry).get(idCity).addPrecipitation(info);
                    break;
                case 8:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    System.out.println("Введите id города");
                    idCity = scanner.nextInt();

                    System.out.println("Максимальная температура: " + controller.getCitiesFromCountry(idCountry).get(idCity).getMaxTemp());
                    System.out.println("Минимальная температура: " + controller.getCitiesFromCountry(idCountry).get(idCity).getMinTemp());
                    System.out.println("Давление: " + controller.getCitiesFromCountry(idCountry).get(idCity).getPressure() + " мм.рт.ст.");
                    System.out.println("Влажность: " + controller.getCitiesFromCountry(idCountry).get(idCity).getHumidity() + " %");
                    System.out.print("Осадки: " + controller.getCitiesFromCountry(idCountry).get(idCity).getPrecipitation());
                    if (controller.getCitiesFromCountry(idCountry).get(idCity).getPrecipitation() ==1){
                        System.out.println("- мало");
                    }
                    if (controller.getCitiesFromCountry(idCountry).get(idCity).getPrecipitation() ==2){
                        System.out.println("- средне");
                    }
                    if (controller.getCitiesFromCountry(idCountry).get(idCity).getPrecipitation() ==3){
                        System.out.println("- много");
                    }
                    break;
                case 9:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    System.out.println("Самый теплый город: " + controller.findCitiesOnInfo(idCountry).get(0) + ". Температура: " + controller.findCitiesOnInfo(idCountry).get(0).getMaxTemp());
                    System.out.println("Самый холодный город: " + controller.findCitiesOnInfo(idCountry).get(1) + ". Температура: " + controller.findCitiesOnInfo(idCountry).get(1).getMinTemp());
                    break;
                case 10:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();

                    System.out.println("Город c максимальным давлением: " + controller.findCitiesOnInfo(idCountry).get(0) + ". Давление: " + controller.findCitiesOnInfo(idCountry).get(0).getPressure()+" мм.рт.ст.");
                    System.out.println("Город c минимальным давлением: " + controller.findCitiesOnInfo(idCountry).get(1) + ". Давление: " + controller.findCitiesOnInfo(idCountry).get(1).getPressure()+" мм.рт.ст.");
                    break;
                case 11:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();

                    System.out.println("Город c максимальной влажностью: " + controller.findCitiesOnInfo(idCountry).get(0) + ". Влажность: " + controller.findCitiesOnInfo(idCountry).get(0).getHumidity() + " %");
                    System.out.println("Город c минимальной влажностью: " + controller.findCitiesOnInfo(idCountry).get(1) + ". Влажность: " + controller.findCitiesOnInfo(idCountry).get(1).getHumidity() + " %");
                    break;
                case 12:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();

                    System.out.println("Город c максимальным количеством осадков: " + controller.findCitiesOnInfo(idCountry).get(0));
                    System.out.println("Город c минимальным количеством осадков: " + controller.findCitiesOnInfo(idCountry).get(1));
                    break;
                case 13:
                    System.out.println("Введите id страны");
                    idCountry = scanner.nextInt();
                    System.out.println("Самый комфортный город для жизни: " + controller.findTheBestCitiForLife(idCountry).get(0));
                    break;
                default:
                    System.out.println("МИМО");
            }
        }
            while (choice != 0) ;

        }
    }

