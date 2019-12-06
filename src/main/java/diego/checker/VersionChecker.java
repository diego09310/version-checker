package diego.checker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class VersionChecker {

    public String check(String v1, String v2) {
        VersionComparator comparator = new VersionComparator();
        int comparison = comparator.compare(v1, v2);
        if (comparison > 0) {
            return "before";
        } else if (comparison < 0) {
            return "after";
        } else {
            return "equal";
        }
    }

    private class VersionComparator implements Comparator<String> {

        @Override
        public int compare(String v1, String v2) {
            if (v1.equals(v2)) {
                return 0;
            }
            List<Integer> ver1 = Arrays.stream(v1.split("\\."))
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            List<Integer> ver2 = Arrays.stream(v2.split("\\."))
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            int i = 0;
            int length1 = ver1.size();
            int length2 = ver2.size();

            while(i < length1 || i < length2) {
                int subversion1 = i < length1 ? ver1.get(i) : 0;
                int subversion2 = i < length2 ? ver2.get(i) : 0;
                if (subversion1 > subversion2) {
                    return 1;
                } else if (subversion1 < subversion2) {
                    return -1;
                }
                i++;
            }
            return 0;
        }
    }
}
