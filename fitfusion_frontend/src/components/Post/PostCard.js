import * as React from 'react';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import {Avatar, CardActions, CardContent, CardMedia, IconButton} from "@mui/material";
import {red} from "@mui/material/colors";
import Typography from "@mui/material/Typography";
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ChatIcon from '@mui/icons-material/Chat';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';


const postcard = () =>{
    return(

            <Card >
                <CardHeader
                    avatar={
                        <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                            R
                        </Avatar>
                    }
                    action={
                        <IconButton aria-label="settings">
                            <MoreVertIcon />
                        </IconButton>
                    }
                    title="Shrimp and Chorizo Paella"
                    subheader="September 14, 2016"
                />
                <CardMedia
                    component="img"
                    height="194"
                    image="https://cdn.pixabay.com/photo/2023/10/26/08/24/autumn-8342089_640.jpg"
                    alt="Paella dish"
                />

                <CardContent>
                    <Typography variant="body2" color="text.secondary">
                        This impressive paella is a perfect party dish and a fun meal to cook
                        together with your guests. Add 1 cup of frozen peas along with the mussels,
                        if you like.
                    </Typography>
                </CardContent>

                <CardActions className="flex justify-between" disableSpacing>
                    <div>
                        <IconButton aria-label="add to favorites">
                            {true?<FavoriteIcon/> : <FavoriteBorderIcon/>}
                        </IconButton>
                        <IconButton aria-label="share">
                            <ShareIcon/>
                        </IconButton>
                        <IconButton aria-label="comment">
                            <ChatIcon/>
                        </IconButton>
                    </div>
                    <div>
                        <IconButton aria-label="share">
                            {true ? <BookmarkBorderIcon/> : <BookmarkIcon/>}
                        </IconButton>
                    </div>
                </CardActions>
            </Card>

    );
}
export default postcard;