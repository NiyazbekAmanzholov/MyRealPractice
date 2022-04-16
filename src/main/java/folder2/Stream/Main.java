package folder2.Stream;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("column_name", "name");
        map.put("data_type", "text");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("column_name", "name2");
        map2.put("data_type", "varchar");

        Map<String, Object> map3 = new HashMap<>();
        map3.put("column_name", "name3");
        map3.put("data_type", "date");

        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map2);
        mapList.add(map3);

        System.out.println(buildSqlForUpdate(mapList));
    }

    private static String buildSqlForUpdate(List<Map<String, Object>> mapList) {
        StringBuilder sqlSet = new StringBuilder();

        mapList.stream().flatMap(map -> map.entrySet().stream())
                .forEach(entry -> sqlSet.append(entry.getValue()).append(" "));

        return sqlSet.toString()
                .replaceAll("([^ ]+ [^ ]+) ", "ADD COLUMN IF NOT EXISTS $1, ")
                .replaceAll("\\s*,\\s*$", "");
    }


    private String buildSqlForUpdate2(List<Map<String, Object>> mapList) {
        StringBuilder sqlSet = new StringBuilder();
        if (mapList.size() > 0) {
            for (Map<String, Object> data : mapList) {
                data.forEach((k, v) -> {
                    sqlSet.append(v).append(" ");
                });
            }
        }

        return sqlSet.toString()
                .replaceAll("([^ ]+ [^ ]+) ", "ADD COLUMN IF NOT EXISTS $1, ")
                .replaceAll("\\s*,\\s*$", "");
    }


}

