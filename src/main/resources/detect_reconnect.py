#!/usr/local/bin/python3

import cv2
import datetime
import time


def reset_attempts():
    return 50


def process_video(attempts):

    while(True):
        (grabbed, frame) = camera.read()

        if not grabbed:
            print("disconnected!")
            camera.release()

            if attempts > 0:
                time.sleep(5)
                return True
            else:
                return False


recall = True
attempts = reset_attempts()

while(recall):
    camera = cv2.VideoCapture("rtsp://<ip><port>/live0.264")

    if camera.isOpened():
        print("[INFO] Camera connected at " +
              datetime.datetime.now().strftime("%m-%d-%Y %I:%M:%S%p"))
        attempts = reset_attempts()
        recall = process_video(attempts)
    else:
        print("Camera not opened " +
              datetime.datetime.now().strftime("%m-%d-%Y %I:%M:%S%p"))
        camera.release()
        attempts -= 1
        print("attempts: " + str(attempts))

        # give the camera some time to recover
        time.sleep(5)
        continue