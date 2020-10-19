package ch.cyberduck.core.sds.triplecrypt;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.sds.io.swagger.client.model.FileKey;
import ch.cyberduck.core.sds.io.swagger.client.model.FileKeyContainer;
import ch.cyberduck.core.sds.io.swagger.client.model.PrivateKeyContainer;
import ch.cyberduck.core.sds.io.swagger.client.model.PublicKeyContainer;
import ch.cyberduck.core.sds.io.swagger.client.model.UserKeyPairContainer;

import com.dracoon.sdk.crypto.error.UnknownVersionException;
import com.dracoon.sdk.crypto.model.EncryptedFileKey;
import com.dracoon.sdk.crypto.model.PlainFileKey;
import com.dracoon.sdk.crypto.model.UserKeyPair;
import com.dracoon.sdk.crypto.model.UserPrivateKey;
import com.dracoon.sdk.crypto.model.UserPublicKey;

public class TripleCryptConverter {
    public static FileKey toSwaggerFileKey(final EncryptedFileKey k) {
        return new FileKey().key(k.getKey()).iv(k.getIv()).tag(k.getTag()).version(k.getVersion().getValue());
    }

    public static FileKey toSwaggerFileKey(final PlainFileKey k) {
        return new FileKey().key(k.getKey()).iv(k.getIv()).tag(k.getTag()).version(k.getVersion().getValue());
    }

    public static UserKeyPairContainer toSwaggerUserKeyPairContainer(final UserKeyPair pair) {
        final UserKeyPairContainer container = new UserKeyPairContainer();
        container.setPrivateKeyContainer(new PrivateKeyContainer().privateKey(pair.getUserPrivateKey().getPrivateKey()).version(pair.getUserPrivateKey().getVersion().getValue()));
        container.setPublicKeyContainer(new PublicKeyContainer().publicKey(pair.getUserPublicKey().getPublicKey()).version(pair.getUserPublicKey().getVersion().getValue()));
        return container;
    }

    public static UserKeyPair toCryptoUserKeyPair(final UserKeyPairContainer c) throws UnknownVersionException {
        final UserPrivateKey privateKey = new UserPrivateKey(UserKeyPair.Version.getByValue(c.getPrivateKeyContainer().getVersion()),
            c.getPrivateKeyContainer().getPrivateKey());
        final UserPublicKey publicKey = new UserPublicKey(UserKeyPair.Version.getByValue(c.getPublicKeyContainer().getVersion()),
            c.getPublicKeyContainer().getPublicKey());
        return new UserKeyPair(privateKey, publicKey);
    }

    public static UserPublicKey toCryptoUserPublicKey(final PublicKeyContainer c) throws UnknownVersionException {
        return new UserPublicKey(UserKeyPair.Version.getByValue(c.getVersion()), c.getPublicKey());
    }

    public static UserPrivateKey toCryptoUserPrivateKey(final PrivateKeyContainer c) throws UnknownVersionException {
        return new UserPrivateKey(UserKeyPair.Version.getByValue(c.getVersion()), c.getPrivateKey());
    }

    public static PlainFileKey toCryptoPlainFileKey(final FileKey key) throws UnknownVersionException {
        final PlainFileKey fileKey = new PlainFileKey(PlainFileKey.Version.getByValue(key.getVersion()), key.getKey(), key.getIv());
        fileKey.setTag(key.getTag());
        return fileKey;
    }

    public static EncryptedFileKey toCryptoEncryptedFileKey(final FileKeyContainer key) throws UnknownVersionException {
        final EncryptedFileKey fileKey = new EncryptedFileKey(EncryptedFileKey.Version.getByValue(key.getVersion()), key.getKey(), key.getIv());
        fileKey.setTag(key.getTag());
        return fileKey;
    }

    public static EncryptedFileKey toCryptoEncryptedFileKey(final FileKey k) throws UnknownVersionException {
        final EncryptedFileKey key = new EncryptedFileKey(EncryptedFileKey.Version.getByValue(k.getVersion()), k.getKey(), k.getIv());
        key.setTag(k.getTag());
        return key;
    }
}
