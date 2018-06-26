package io.github.cslysy.codereview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CodeReviewTest {

    private static final Logger logger = LoggerFactory.getLogger(CodeReviewTest.class);

    public static void main(String[] args) throws Exception {
        logger.info("Starting application");
        final DatabaseUserManager DatabaseManager = new DatabaseUserManager("myDatabase");
        UserService userService = new UserService();
        userService.setUserManager(DatabaseManager);
        printAllUsers(userService, new File("user-ids.txt"));
    }

    private static void printAllUsers(final UserService userService, final File userFile) throws IOException {
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(userFile);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String userId = reader.readLine();
            while (userId != null) {
                User user = userService.getUserById(userId);
                logger.info("User " + user.name + " " + user.surname + " found");
                userId = reader.readLine();
            }
        } catch (Exception ex) {
            logger.error("Could not ");
        } finally {
            reader.close();
            inputStream.close();
        }
    }

    static class UserService {
        public DatabaseUserManager userManager;

        public User getUserById(String id) {
            validateUserId(id);
            return userManager.findById(id);
        }

        private void validateUserId(String id) {
            if (id.length() < 8) {
                throw new RuntimeException("User id is too short");
            }
        }

        public void setUserManager(DatabaseUserManager userManager) {
            this.userManager = userManager;
        }

        public DatabaseUserManager getUserManager() {
            return userManager;
        }
    }

    static class DatabaseUserManager {
        public static final String defaultHost = "localhost";
        public static final int defaultPort = 3306;
        private String host;
        private int port;
        private String databaseName;

        public DatabaseUserManager(String host, int port, String databaseName) {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
        }

        public DatabaseUserManager(String databaseName) {
            this.databaseName = databaseName;
            this.host = defaultHost;
            this.port = defaultPort;
        }

        public User findById(String id) {
            try {
                return DatabaseUtil.getObjectById(User.class, id);
            } catch (Error e) {
                logger.info("Could not find user");
                return null;
            }
        }
    }
}