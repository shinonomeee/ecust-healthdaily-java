package cn.ecust.constants.error;

public enum ErrorType {
    SUCCESS,                        // 成功
    ElementNotInteractable,         // Element is not interactable
    NoSuchElement_FillinButton,     // No such element found by css selector: #fillin_button
    RuntimeError_Login,             // Runtime error when login
    RuntimeError_Fillin,            // Runtime error when filling in
    NoSuchElement                   // No such element
}
