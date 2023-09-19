import { useState } from "react";

function App() {
  const [firstName, setfirstName] = useState("");
  const [lastName, setlastName] = useState("");

  async function Submit(e) {
    e.preventDefault();
    if (firstName === "" || lastName === "") {
      alert("Please fill in all boxes!");
    } else {
      await fetch(`http://localhost:8081/users`,{
        method:"POST",
        headers:{
          "Content-Type":"application/json"
        },
        body:JSON.stringify({
          firstName,
          lastName
        })
      }).then(()=>{
        alert("Submission Successful");
      });
    }
  }

  return (
    <div className="form">
      <form>
        <input
          name="FirstName"
          onChange={(e) => setfirstName(e.target.value)}
          placeholder="First Name"
          required
        />
        <br />
        <input
          name="LastName"
          onChange={(e) => setlastName(e.target.value)}
          placeholder="Last Name"
          required
        />
        <br />
        <button onClick={Submit}>Submit</button>
      </form>
    </div>
  );
}

export default App;
