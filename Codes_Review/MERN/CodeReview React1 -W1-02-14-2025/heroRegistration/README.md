### **React Code Review Assignment**  

#### **Objective:**  
This project involves creating a React application that includes a user information form, a data display component, and conditional alerts based on user input. The project will utilize the following React concepts and technologies:
Props / Hook ( useState ) / Styling ( CSS - Bootstrap ) / Forms / Arrow Functions / Map Function / Callback Functions 

#### **Tasks:**  

1. **Create the Form Component:**  
   - Design a React component that includes the following fields:  
     - `Name` (Text input)  
     - `Email` (Text input)  
     - `Password` (Password input)  
     - `Favorite Hero` (Select input: Superman, Wonder Woman, Batman, Spider-Man, Iron Man)
     - Checkbox for "I accept the terms and conditions"  
     - Submit button  

2. **Form Submission Logic:**  
   - On form submission:  
     - If the checkbox is not checked, display an alert:  
       - `"Please accept the terms and conditions to proceed."`  
     - If the checkbox **is** checked, display an alert:  
       - `"🎮 Congratulations, you're ready to play the game! 🎮"`  
       
3. **Create the Data Display Component:**  
   - Create a separate component that displays the user's information dynamically.  

4. **Styling and Layout:**  
   - Ensure that components are displayed side by side.  
   - Use Bootstrap & CSS for styling.



#### **Technologies and Concepts Used in the Project:**  
 - Props: Passing data from the parent component (App) to the child component (UserInfo) to enable data sharing between components.
 - Hook (useState Hook): Managing form state to track user input and update the UI dynamically.
 - CSS & Bootstrap : Styling components to create a consistent and visually appealing user interface.
 - Forms: Handling user input and submission dynamically using React.
 - Arrow Functions: Defining handler functions concisely to improve code readability.
 - Map Function: Dynamically generating options for the select input using an array of heroes.
 - Callback Functions: Handling input changes and form submission efficiently to keep state in sync with input fields.

