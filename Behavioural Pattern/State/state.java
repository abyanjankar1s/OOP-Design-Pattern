// Implement the State design pattern.

// The State is a behavioral design pattern that allows an object 
//to alter its behavior when its internal state changes. 
//This pattern is often used to encapsulate the state-related 
//behavior within state-specific classes, avoiding large conditional
// statements in the object's methods.

// You are given a basic Document class, which can be in one of 
//three states: Draft, Review, or Published. The behavior of the 
//publish method should change based on the current state of the 
//document.

// Your task is to implement the State design pattern by creating 
//state classes and updating the Document class so that it changes
// its behavior according to its state.

// States:

// Draft: A document in this state can move to the Review state.
// Review: A document in this state can be either approved to 
//move to the Published state or rejected to return to the Draft 
//state, depending on the value of isApproved in the Document class.
// Published: A document in this state cannot change its state 
//anymore.

interface State {
    void handleRequest(Document doc);
}

class Document {
    private State state;
    private boolean isApproved;

    public Document(){
        this.state = new Draft();
    }
    public State getState() {
        return this.state;
    }
    public void setState(State state){
        this.state = state;
    }
    public void publish() {
        this.state.handleRequest(this);
    }
    public void setApproval(boolean isApproved){
        this.isApproved = isApproved;
    }
    public boolean isApproved(){
        return this.isApproved;
    }
}

class Draft implements State {
    @Override
    public void handleRequest(Document doc){
        doc.setState(new Review());
    }
}

class Review implements State {
    @Override
    public void handleRequest(Document doc){
        if(doc.isApproved()){
            doc.setState(new Published());
        } else {
            doc.setState(new Draft());
        }
    }
}

class Published implements State {
    @Override
    public void handleRequest(Document doc){
    }
}


// Document document = new Document();
// document.getState() instanceof Draft; // true

// document.publish();
// document.getState() instanceof Review; // true

// document.publish();
// document.getState() instanceof Draft; // true

// document.setApproval(true);
// document.publish(); // Draft -> Review
// document.publish(); // Review -> Published
// document.getState() instanceof Published; // true

// document.publish();
// document.getState() instanceof Published; // true

