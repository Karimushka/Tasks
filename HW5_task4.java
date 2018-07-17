public class HW5_task4 {
    //4. *Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.
 //Cкобки не учитываются в данном решении. Условие реализации - использовать только базовый оператор ветвления и цикл for

    //Базовый метод
    void task4(String string){
        char[] mass = string.toCharArray(); // преобразовываем строку в char массив
        char[] convert = new char[mass.length]; // заводим еще один массив (результативный)
        task4_1(mass,convert,0,0);
        System.out.println(convert);
        System.out.println(mass);
    }

    //Метод для 4-го задания
    void task4_1(char [] arrStart, char [] arrResult, int stopRight, int currentStop) {
        for (int i = 0; i < arrStart.length; i++) {
            if (arrStart[i] == '*' || arrStart[i] == '/') {
                stopRight = i;
                currentStop = stopRight;
                for (int i1 = 0; i1 < stopRight+2; i1++){
                    if (arrStart[i1] != '+' && arrStart[i1] != '-' && arrStart[i1] != '/' && arrStart[i1] != '*' && arrStart[i1] != ' '){
                        pushStak(arrResult,arrStart[i1]);
                        arrStart[i1] = ' ';
                    }
                }
                for (int i1 = stopRight; i1 > 0; i1--){
                    if (arrStart[i1] != ' '){
                        pushStak(arrResult,arrStart[i1]);
                        arrStart[i1] = ' ';
                    }
                }
            }
            else if (arrStart[i] != '+' && arrStart[i] != '-' && arrStart[i] != '/' && arrStart[i] != '*' && arrStart[i] != ' '){
                pushStak(arrResult,arrStart[i]);
                arrStart[i] = ' ';
            }
        }
        for (int i = arrStart.length - 1;i > currentStop; i--){
            if (arrStart[i] == '+' || arrStart[i] == '-'){
                pushStak(arrResult,arrStart[i]);
                arrStart[i] = ' ';
            }
        }
    }
    // Метод передачи значения
    final int i2 = -1;
    int i3 = i2;

    void pushStak(char[] arr, char charact) {
        i3++;
        arr[i3] = charact;
    }
}
