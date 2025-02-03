const cloud_name = "dlnrszsa9";
const upload_preset = "ml_default";

export const uploadToCloudinary = async (pics, fileType) => {
    if (pics && fileType) {
        const data = new FormData();
        data.append("file", pics);
        data.append("upload_preset", upload_preset);
        data.append("cloud_name", cloud_name); // Corrected parameter name

        try {
            const response = await fetch(
                `https://api.cloudinary.com/v1_1/${cloud_name}/${fileType}/upload`,
                {
                    method: "POST",
                    body: data,
                }
            );

            if (!response.ok) {
                throw new Error("Failed to upload file");
            }

            const fileData = await response.json();
            console.log("rest ---", fileData.url);
            return fileData.url;
        } catch (error) {
            console.error("Error uploading file:", error);
            return null;
        }
    } else {
        console.error("Error: No picture or file type provided.");
        return null;
    }
};
