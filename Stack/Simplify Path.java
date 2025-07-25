class Solution {

    Stack<String> sequenceStack = new Stack<>();
    private static final String PARENT_DIR = "..";
    private static final String CURRENT_DIR = ".";

    public String simplifyPath(String path) {
        String simplifiedCanonicalPath = "";
        String temporaryStr = "";
        int i = 0;

        for (i = 0; i < path.length();) {
            if (!temporaryStr.isEmpty() && i < path.length()) {
                var lastTemporaryChar = temporaryStr.charAt(temporaryStr.length() - 1);
                if (Character.isLetter(lastTemporaryChar) && (path.charAt(i) == '.' || path.charAt(i) == '/')) {
                    sequenceStack.push(temporaryStr);
                    temporaryStr = "";
                    continue;
                }

                if (lastTemporaryChar == '.' && (Character.isLetter(path.charAt(i)) || path.charAt(i) == '/')) {
                    sequenceStack.push(temporaryStr);
                    temporaryStr = "";
                    continue;
                }

                if (lastTemporaryChar == '/' && (Character.isLetter(path.charAt(i)) || path.charAt(i) == '.')) {
                    sequenceStack.push(temporaryStr);
                    temporaryStr = "";
                    continue;
                }
            }

            if (i < path.length() && Character.isLetter(path.charAt(i))) {
                temporaryStr += path.charAt(i);
                i++;
                continue;
            }

            if (i < path.length() && path.charAt(i) == '.') {
                temporaryStr += path.charAt(i++);
                while (i < path.length() && path.charAt(i) == '.') {
                    temporaryStr += path.charAt(i++);
                }
                continue;
            }

            if (i < path.length() && path.charAt(i) == '/') {
                temporaryStr += path.charAt(i);
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
            }
        }

        if (i == path.length()) {
            sequenceStack.push(temporaryStr);
        }

        // Generating simplified canonical path
        if (sequenceStack.peek().equals("/")) {
            sequenceStack.pop();
        }

        while (!sequenceStack.isEmpty()) {
            var poppedString = sequenceStack.pop();
            if (poppedString.equals(PARENT_DIR)) {
                for (int index = 0; index < 3; index++) {
                    if (!sequenceStack.isEmpty()) {
                        sequenceStack.pop();
                    } else {
                        break;
                    }
                }

                continue;
            }

            if (poppedString.equals(CURRENT_DIR)) {
                if (!sequenceStack.isEmpty()) {
                    sequenceStack.pop();
                }
                continue;
            }

            simplifiedCanonicalPath = poppedString + simplifiedCanonicalPath;
        }

        return !simplifiedCanonicalPath.isEmpty() && simplifiedCanonicalPath.charAt(0) == '/' ? simplifiedCanonicalPath
                : "/" + simplifiedCanonicalPath;
    }
}

// Accepted Version

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(); // create a stack to keep track of directories
        String[] directories = path.split("/"); // split the path by slash '/'
        for (String dir : directories) { // iterate over the directories
            if (dir.equals(".") || dir.isEmpty()) { // ignore the current directory '.' and empty directories
                continue;
            } else if (dir.equals("..")) { // go one level up for double period '..'
                if (!stack.isEmpty()) { // if stack is not empty, pop the top element
                    stack.pop();
                }
            } else { // for any other directory, push it to the stack
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack); // join the directories in the stack with slash '/' and add a slash at the beginning
    }
}
