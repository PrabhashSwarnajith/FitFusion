import React from "react";
import CardHeader from "@mui/material/CardHeader";
import {Avatar, IconButton} from "@mui/material";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import Button from "@mui/material/Button";
import {red} from "@mui/material/colors";

const PopularUsers = () =>{
    return(
        <div className='pr-5'>
            <CardHeader
                avatar={
                    <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                        R
                    </Avatar>
                }
                action={
                    <Button >Follow</Button>
                }
                title="Shrimp and Chorizo Paella"
                subheader="September 14, 2016"
            />
        </div>
    )
}
export default PopularUsers;