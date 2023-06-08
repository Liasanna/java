static int doCalc(String[][] matrix) {
        if (matrix.length != 4 ) throw new ArraySizeException(" Make matrix size 4x4");
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               sum += Integer.parseInt(matrix[i][j]);
            }
        }
        return sum;
    }

public static void main(String[] args) {
    int result = 0;
    try {
        result = doCalc(new String[][] {{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}});
    } catch (ArraySizeException ex) {
        System.out.println(ex.getMessage());
        result = doCalc(new String[][] {{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
}catch (ArrayDataException exception){
    System.out.println(exception.getMessage());
    result = doCalc(new String[][] {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
}
System.out.println(" Sum = " + result);
}

static int doCalc(String[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix.length != 4 || matrix[i].length != 4) throw new ArraySizeException("Make matrix size 4x4");
            try {
                sum += Integer.parseInt(matrix[i][j]);
            } catch (NumberFormatException e) {
                throw new ArrayDataException("Incorrect array's data : " + i + " - " + j);
            }
        }
    }
    return sum;
}

public static void main(String[] args) {
    
    //пробуем с заведомо некорректным размером массива
    try {
        int result = doCalc(new String[][]{{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}});
        System.out.println(result);    
    } catch (ArraySizeException | ArrayDataException ex) {
        System.out.println(ex.getMessage());
    }
    
    //пробуем с заведомо некорректными данными в массиве
    try {
        int result = doCalc(new String[][]{{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
        System.out.println(result);        
    } catch (ArraySizeException | ArrayDataException exception) {
        System.out.println(exception.getMessage());            
    }

    //пробуем корреткные данные
    try {
        int result = doCalc(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
        System.out.println(result);        
    } catch (ArraySizeException | ArrayDataException exception) {
        System.out.println(exception.getMessage());            
    }
    
}
