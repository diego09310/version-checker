package diego.checker;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class VersionCheckerController {

    private static final String VERSION_REGEX = "^\\d+(.\\d+)*";
    private static final Pattern VERSION_PATTERN = Pattern.compile(VERSION_REGEX);
    private static final String ERROR_MESSAGE = "Invalid version format";

    @Autowired
    private VersionChecker versionChecker;

    @GetMapping
    @ResponseBody
    public String checkVersion(@RequestParam("v1") String version1, @RequestParam("v2") String version2) {
        if (!(VERSION_PATTERN.matcher(version1).matches() && VERSION_PATTERN.matcher(version2).matches())) {
            return ERROR_MESSAGE;
        }
        return versionChecker.check(version1, version2);
    }
}
