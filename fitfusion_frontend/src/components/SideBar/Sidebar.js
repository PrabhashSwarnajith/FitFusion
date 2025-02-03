import React from "react";
import { useNavigate } from "react-router-dom";
import { sideBarNavigation } from "./SideBarNavigation";
import { Avatar, Card, Divider, Menu, MenuItem } from "@mui/material";
import Button from "@mui/material/Button";
import { MoreVert } from "@mui/icons-material";

const Sidebar = () => {
    const navigate = useNavigate(); // Initialize useNavigate hook

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    // const handleProfileClick = () => {
    //     handleClose(); // Close the menu
    //     navigate("/profile"); // Navigate to profile page
    // };

    return (
        <Card className='card h-screen flex flex-col justify-between py-5'>
            <div className='space-y-8 pl-5'>
                <div className=''>
                    <span className='logo font-bold text-xl'>FitFusion</span>
                </div>
                <div className='space-y-8'>
                    {sideBarNavigation.map((item, index) => (
                        <div key={index} className='cursor-pointer flex space-x-3 items-center'>
                            {item.icon}
                            <p className='text-xl'>{item.title}</p>
                        </div>
                    ))}
                </div>
            </div>
            <div>
                <Divider />
                <div className='pl-5 flex items-center justify-between pt-5'>
                    <Avatar />
                    <p className='font-bold'>code with zosh</p>
                    <p className='opacity-70'>@code with zosh</p>

                    <div>
                        <Button
                            id="basic-button"
                            aria-controls={open ? 'basic-menu' : undefined}
                            aria-haspopup="true"
                            aria-expanded={open ? 'true' : undefined}
                            onClick={handleClick}
                        >
                            <MoreVert />
                        </Button>
                        <Menu
                            id="basic-menu"
                            anchorEl={anchorEl}
                            open={open}
                            onClose={handleClose}
                            MenuListProps={{
                                'aria-labelledby': 'basic-button',
                            }}
                        >
                            <MenuItem onClick={handleClose}>Logout</MenuItem>
                        </Menu>
                    </div>
                </div>
            </div>
        </Card>
    );
};

export default Sidebar;
