package org.ton.intellij.tlb.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.ton.intellij.tlb.TlbFileType
import org.ton.intellij.util.childOfType

val Project.tlbPsiFactory get() = TlbPsiFactory(this)

class TlbPsiFactory(val project: Project) {
    inline fun <reified T : TlbElement> createFromText(code: CharSequence): T? =
        PsiFileFactory.getInstance(project)
            .createFileFromText("DUMMY.tlb", TlbFileType, code)
            .childOfType()
}
