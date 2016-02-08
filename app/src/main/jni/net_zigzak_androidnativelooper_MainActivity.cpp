#include "net_zigzak_androidnativelooper_MainActivity.h"
#include <jni.h>

JNIEXPORT void JNICALL Java_net_zigzak_androidnativelooper_MainActivity_sendMyMessage(JNIEnv *env, jobject, jobject handler) {
    jclass clazz = env->GetObjectClass(handler);
    jmethodID sendMessage = env->GetMethodID(clazz, "sendEmptyMessage", "(I)Z");
    jboolean succes = env->CallBooleanMethod(handler, sendMessage);
}
