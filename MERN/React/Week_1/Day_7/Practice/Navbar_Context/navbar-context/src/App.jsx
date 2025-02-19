import {createContext, useState} from "react";
import NavBar from "./components/NavBar";
import FormWrapper from "./components/FormWrapper";


const UserContext = createContext()
export { UserContext }


function App() {

  const [name, setName] = useState("Bob Smith");
  

  return (
    <UserContext.Provider value={{
      name,
      setName
    }}>
      <NavBar />
      <FormWrapper />
    </UserContext.Provider>
  );
}


export default App;