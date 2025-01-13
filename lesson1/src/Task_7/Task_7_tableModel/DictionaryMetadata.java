package src.Task_7.Task_7_tableModel;

public class DictionaryMetadata {
    public static void main(String[] args) {
        TableModel tableModel1 = new TableModel("baseName", "tableName", PublishTypeEnum.NONE);
        tableModel1.setCode("code");
        TableModel tableModel2 = new TableModel("baseName", "tableName", PublishTypeEnum.NONE);
        TableModel tableModel3 = tableModel1;
        System.out.printf("Модель 1:%n%s%n" +
                "Модель 2:%n%s%n" +
                "Модель 3:%n%s%n",
                tableModel1,tableModel2,tableModel3);
        System.out.println("Сравнение таблицы tableModel1 и tableModel2 - " + tableModel1.equals(tableModel2));
        System.out.println("Сравнение таблицы tableModel3 и tableModel1 - " + tableModel1.equals(tableModel3));
    }
}