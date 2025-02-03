import React from "react";
import {Avatar} from "@mui/material";



const story = () =>{
    return(
        <div className='flex items-center p-5 rounded-b-md'>
            <div  className="flex flex-col items-center mr-4 cursor-pointer">
                <Avatar
                    sx={{width:"5rem", height:"5rem"}}
                    // src={}
                >
                </Avatar>
                <p>code.</p>
            </div>

        </div>
    );
}
export default story;