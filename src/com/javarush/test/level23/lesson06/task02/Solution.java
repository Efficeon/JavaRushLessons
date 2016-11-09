package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants{
        public static final String SERVERNotAccessibleException = "Server is not accessible for now.";
        public static final String UNAUTHORizedUserException = "Server is not accessible for now.";
        public static final String BANNEDUserException = "User is banned.";
        public static final String RESTrictionException = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVERNotAccessibleException);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVERNotAccessibleException, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORizedUserException);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORizedUserException, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNEDUserException);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNEDUserException, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTrictionException);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTrictionException, cause);
        }
    }
}
