import SwiftUI
import shared

struct DetailSuccessUi: View {
    
    @State var content: DetailContent?
    @Environment(\.dismiss) private var dismiss // Para voltar à tela anterior

    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                CustomToolbar(
                    title: "Descrição",
                    backAction: { dismiss() },
                    saveAction: { print("Salvar pressionado") },
                    isSaved: false
                )
                .padding(.vertical)
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .navigationBarBackButtonHidden(true)
    }
}

#Preview {
    DetailSuccessUi()
}
