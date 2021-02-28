package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputFile {
    public int intersectionCount = 0;
    public Map<Integer, List<Pair<String, Integer>>> result;

    public OutputFile() {
        result = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(intersectionCount).append(System.lineSeparator());
        for (Map.Entry<Integer, List<Pair<String, Integer>>> e : result.entrySet()) {
            int idx = e.getKey();
            sb.append(idx).append(System.lineSeparator());
            int len = e.getValue().size();
            sb.append(len).append(System.lineSeparator());
            for (Pair<String, Integer> p : e.getValue()) {
                sb.append(p.key).append(' ').append(p.value).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}


