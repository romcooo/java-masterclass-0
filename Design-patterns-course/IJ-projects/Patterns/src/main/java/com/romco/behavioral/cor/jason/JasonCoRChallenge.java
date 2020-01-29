package com.romco.behavioral.cor.jason;

enum Type {
    FAX, EMAIL, UNKNOWN
}
enum Priority {
    HIGH, NORMAL
}

class MyError {
    private String description;
    private Type type;
    private Priority priority;
    
    public MyError(String description, Type type, Priority priority) {
        this.description = description;
        this.type = type;
        this.priority = priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}

interface ErrorHandler {
    void setNext(ErrorHandler next);
    void handle(MyError error);
}

class FaxErrorHandler implements ErrorHandler {
    private ErrorHandler next;
    @Override
    public void setNext(ErrorHandler next) {
        this.next = next;
    }
    
    @Override
    public void handle(MyError error) {
        if (error.getType() == Type.FAX) {
            System.out.println("Handling FAX error of priority " + error.getPriority().toString());
            System.out.println(error.getDescription());
            System.out.println("====");
        } else {
            next.handle(error);
        }
    }
}

class EmailErrorHandler implements ErrorHandler {
    private ErrorHandler next;
    @Override
    public void setNext(ErrorHandler next) {
        this.next = next;
    }
    
    @Override
    public void handle(MyError error) {
        if (error.getType() == Type.EMAIL) {
            System.out.println("Handling EMAIL error of priority " + error.getPriority().toString());
            System.out.println(error.getDescription());
            System.out.println("====");
        } else {
            if (this.next != null) {
                next.handle(error);
            } else {
                System.out.println("No more handlers to handle error!");
            }
        }
    }
}

public class JasonCoRChallenge {
    public static void main(String[] args) {
        ErrorHandler faxErrorHandler = new FaxErrorHandler();
        ErrorHandler emailErrorHandler = new EmailErrorHandler();
        MyError faxNormal = new MyError("some normal fax error", Type.FAX, Priority.NORMAL);
        MyError faxHigh = new MyError("some high fax error", Type.FAX, Priority.HIGH);
        MyError emailNormal = new MyError("some normal email error", Type.EMAIL, Priority.NORMAL);
        MyError emailHigh = new MyError("some high email error", Type.EMAIL, Priority.HIGH);
        MyError unknownHigh = new MyError("some high unknown error", Type.UNKNOWN, Priority.HIGH);
        
        faxErrorHandler.setNext(emailErrorHandler);
        
        faxErrorHandler.handle(faxNormal);
        faxErrorHandler.handle(faxHigh);
        faxErrorHandler.handle(emailNormal);
        faxErrorHandler.handle(emailHigh);
        faxErrorHandler.handle(unknownHigh);
    }
}
