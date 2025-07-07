import axios from "axios";
import { useEffect, useState } from "react";

function App(){

  const[id,setId]=useState(0);
  const[title,setTitle]=useState("");
  const[description,setDescription]=useState("");
  const[Notes,setNotes]=useState([]);

  useEffect(()=>{
    getAll();
  },[id])
  const addPost=async()=>{
  const res=await axios.post("http://localhost:8080/api/notepad/addNote",
    {
      "title":title,
      "description":description
    }
  )
  console.log(res.data);
  setId(res.data.id);
}

const getAll=async()=>{
  const res=await axios.get("http://localhost:8080/api/notepad/getAll")
  console.log(res.data);
  setNotes(res.data);
}

const editNote=async(id)=>{
  const res=await axios.put(`http://localhost:8080/api/notepad/editnote/${id}`,
    {
      "title":title,
      "description":description
    }
  )
  console.log(res.data);
}
  return(
    <div>
      <div className="container">
        <div className="card">
          <div>
            <label>Enter the title: </label>
            <input type="text" onChange={(e)=>{setTitle(e.target.value)}}/>
          </div>
          <div>
            <label>Enter the Description: </label>
            <input type="text" onChange={(e)=>{setDescription(e.target.value)}}/>
          </div>
          <div>
            <button onClick={()=>{addPost()}}>Add Post</button><br />
          </div>
        </div>
        <div>
          {
            Notes.map((e)=>(
              <div key={e.id}>
                Title: {e.title}
                description: {e.description}
                <div>
                  <button onClick={()=>{editNote(e.id)}}>Edit Post</button>
                </div>
              </div>
              
            ))
          }
        </div>
      </div>
    </div>
  )
}
export default App;