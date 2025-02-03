import React, { useState } from "react";
import { Avatar, Backdrop, CircularProgress, IconButton, Modal, Button } from "@mui/material";
import Box from "@mui/material/Box";
import { useFormik } from "formik";
import ImageIcon from "@mui/icons-material/Image";
import VideoCallIcon from "@mui/icons-material/VideoCall";
import {uploadToCloudinary} from "../../utilis/UploadToCloudinary";

const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 500,
    bgcolor: "background.paper",
    border: "2px solid #000",
    boxShadow: 24,
    p: 4,
    borderRadius:".6rem",
    outlined:"none"
};

const CreatePostModal = ({ handleClose, open }) => {
    const formik = useFormik({
        initialValues: {
            caption: "",
            image: null,
            video: null,
        },
        onSubmit: (values) => {
            // Handle form submission here
            console.log("Form submitted with values:", values);
            // Set loading state to true while submitting
            setIsLoading(true);
            // Simulate asynchronous behavior (replace setTimeout with your actual submission logic)
            setTimeout(() => {
                // Reset form after submission
                formik.resetForm();
                // Set loading state back to false after submission
                setIsLoading(false);
                // Close the modal
                handleClose();
            }, 1000);
        },
    });

    const [selectImage, setSelectImage] = useState(null);
    const [selectVideo, setSelectVideo] = useState(null);
    const [isLoading, setIsLoading] = useState(false);

    const handleSelectImage = async (event) => {
        setIsLoading(true);
        const imageUrl = await uploadToCloudinary(event.target.files[0],"image")
        setSelectImage(imageUrl);
        setIsLoading(false)
        await formik.setFieldValue("image", imageUrl)
    };

    const handleSelectVideo = (event) => {
        const file = event.target.files[0];
        if (file) {
            // Handle video selection here
            console.log("Video selected:", file);
            setSelectVideo(URL.createObjectURL(file));
            formik.setFieldValue("video", file);
        }
    };

    return (
        <Modal
            open={open}
            onClose={handleClose}
            aria-labelledby="modal-modal-title"
            aria-describedby="modal-modal-description"
        >
            <Box sx={style}>
                <form onSubmit={formik.handleSubmit}>
                    <div className="flex space-x-10 items-center rounded-md">
                        <Avatar />
                        <div>
                            <p className="font-bold text-lg">Code with </p>
                            <p className="text-xs">@Code with</p>
                        </div>
                    </div>
                    <div className="flex justify-center py-5">
                        <textarea
                            placeholder="write Caption"
                            name="caption"
                            value={formik.values.caption}
                            onChange={formik.handleChange}
                            style={{ width: "100%", float: "left" }}
                            rows="6"
                        ></textarea>
                    </div>

                    <div className="flex space-x-20 items-center mt-5">
                        <div>
                            <input
                                type="file"
                                accept="image/*"
                                onChange={handleSelectImage}
                                style={{ display: "none" }}
                                id="image-input"
                            />
                            <label htmlFor="image-input">
                                <IconButton color="primary" component="span">
                                    <ImageIcon />
                                </IconButton>
                            </label>
                            <span>Image</span>
                        </div>
                        <div>
                            <input
                                type="file"
                                accept="video/*"
                                onChange={handleSelectVideo}
                                style={{ display: "none" }}
                                id="video-input"
                            />
                            <label htmlFor="video-input">
                                <IconButton color="primary" component="span">
                                    <VideoCallIcon />
                                </IconButton>
                            </label>
                            <span>Video</span>
                            {selectImage && (
                                <div>
                                    <img className="h-[10rem]" src={selectImage} alt="" />
                                </div>
                            )}
                            <div className="flex w-full justify-end">
                                <Button
                                    variant="contained"
                                    type="submit"
                                    style={{ borderRadius: "1.5rem" }}
                                >
                                    Post
                                </Button>
                            </div>
                        </div>
                    </div>
                </form>
                <Backdrop
                    sx={{ color: '#fff', zIndex: (theme) => theme.zIndex.drawer + 1 }}
                    open={isLoading}
                    onClick={handleClose}
                >
                    <CircularProgress color="inherit" />
                </Backdrop>
            </Box>
        </Modal>
    );
};

export default CreatePostModal;
