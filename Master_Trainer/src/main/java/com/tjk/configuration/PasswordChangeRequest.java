package com.tjk.configuration;

/**
 * This class represents a request to change a user's password.
 * It contains the old password and the new password to be set.
 */
public class PasswordChangeRequest {

    private String oldPassword; // The user's current password
    private String newPassword; // The new password to be set

    // Default constructor
    public PasswordChangeRequest() {}

    /**
     * Constructor to create a PasswordChangeRequest with specified old and new passwords.
     *
     * @param oldPassword the current password of the user
     * @param newPassword the new password to be set
     */
    public PasswordChangeRequest(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword; // Initialize old password
        this.newPassword = newPassword; // Initialize new password
    }

    /**
     * Gets the old password.
     *
     * @return the current password of the user
     */
    public String getOldPassword() {
        return oldPassword; // Return the old password
    }

    /**
     * Sets the old password.
     *
     * @param oldPassword the current password of the user to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword; // Update the old password
    }

    /**
     * Gets the new password.
     *
     * @return the new password to be set
     */
    public String getNewPassword() {
        return newPassword; // Return the new password
    }

    /**
     * Sets the new password.
     *
     * @param newPassword the new password to set for the user
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword; // Update the new password
    }
}